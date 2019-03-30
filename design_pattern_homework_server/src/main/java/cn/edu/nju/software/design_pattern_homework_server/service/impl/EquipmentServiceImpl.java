package cn.edu.nju.software.design_pattern_homework_server.service.impl;

import cn.edu.nju.software.design_pattern_homework_server.command.ChangeEquipedCommand;
import cn.edu.nju.software.design_pattern_homework_server.command.EquipCommand;
import cn.edu.nju.software.design_pattern_homework_server.command.UpgradeCommand;
import cn.edu.nju.software.design_pattern_homework_server.common.enumeration.EQUIP_TYPE;
import cn.edu.nju.software.design_pattern_homework_server.common.result.Result;
import cn.edu.nju.software.design_pattern_homework_server.common.strategy.Values;
import cn.edu.nju.software.design_pattern_homework_server.common.strategy.level.EquipmentUpgradeStrategy;
import cn.edu.nju.software.design_pattern_homework_server.common.strategy.level.LevelUpgradeContext;
import cn.edu.nju.software.design_pattern_homework_server.dao.EquipmentRepository;
import cn.edu.nju.software.design_pattern_homework_server.dao.UserCharacterEquipmentRepository;
import cn.edu.nju.software.design_pattern_homework_server.dao.UserCharacterRepository;
import cn.edu.nju.software.design_pattern_homework_server.dto.CharacterEquipmentDto;
import cn.edu.nju.software.design_pattern_homework_server.dto.EquipmentDto;
import cn.edu.nju.software.design_pattern_homework_server.entity.Equipment;
import cn.edu.nju.software.design_pattern_homework_server.entity.UserCharacter;
import cn.edu.nju.software.design_pattern_homework_server.entity.UserCharacterEquipment;
import cn.edu.nju.software.design_pattern_homework_server.service.EquipmentService;
import cn.edu.nju.software.design_pattern_homework_server.util.UpdateUtil;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EquipmentServiceImpl implements EquipmentService {

    @Resource
    private EquipmentRepository equipmentDao;
    @Resource
    private UserCharacterRepository userCharacterDao;
    @Resource
    private UserCharacterEquipmentRepository userCharacterEquipmentDao;

    @Override
    public Result getCharacterEquips(Long userCharacterId) {
        List<UserCharacterEquipment> equipments = userCharacterEquipmentDao.findAllByUserCharacterIdAndEquiped(userCharacterId, false);
        return Result.success().withData(getCharacterEquipmentDtos(equipments));
    }

    @Override
    public Result getEquipedEquips(Long userCharacterId) {
        List<UserCharacterEquipment> equipments = userCharacterEquipmentDao.findAllByUserCharacterIdAndEquiped(userCharacterId, true);
        List<CharacterEquipmentDto> dtos = getCharacterEquipmentDtos(equipments);
        Map<EQUIP_TYPE, CharacterEquipmentDto> map = Maps.newConcurrentMap();
        dtos.forEach(dto -> map.put(dto.getType(), dto));
        return Result.success().message("当前角色已穿戴的装备").withData(map);
    }

    @Override
    public Result getAllEuips() {
        List<Equipment> equipments = Lists.newArrayList(equipmentDao.findAll());
        return Result.success().message("获取所有装备数据成功！").withData(getEquipmentDtos(equipments));
    }

    @Override
    public Long getMaxEquipId() {
        return equipmentDao.maxId();
    }

    @Override
    public Long getMinEquipId() {
        return equipmentDao.minId();
    }

    @Override
    public Result getAllEquips(Long characterId) {
        List<Equipment> equipments = Lists.newArrayList(equipmentDao.findAllByCharacterId(characterId));
        return Result.success().message("获取角色的所有装备数据成功！").withData(getEquipmentDtos(equipments));
    }

    @Override
    public Result getAllEquips(Long userCharacterId, Boolean equiped) {
        if (equiped) {
            return getEquipedEquips(userCharacterId);
        }
        return getCharacterEquips(userCharacterId);
    }

    @Override
    public Result upgrade(UpgradeCommand command) {
        Optional<UserCharacterEquipment> op_equip = userCharacterEquipmentDao.findById(command.getId());
        if (!op_equip.isPresent()) {
            return Result.error().message("装备信息不存在！");
        }
        UserCharacterEquipment equip = op_equip.get();
        return upgrade(equip);
    }

    @Override
    public Result pickUpEquip(List<EquipCommand> equipments, Long userCharacterId) {
        if (null == equipments || equipments.size() == 0) {
            return Result.success().message("角色并未未捡装备！");
        }
        List<UserCharacterEquipment> equips = Lists.newArrayList();
        for (EquipCommand command : equipments) {
            Optional<Equipment> equipment = equipmentDao.findById(command.getId());
            UserCharacterEquipment equip = new UserCharacterEquipment();
            BeanUtils.copyProperties(equipment.get(), equip, "id");
            equip.setUpgradeTimes(0);
            equip.setCount(1);
            equip.setEquiped(false);
            equip.setUserCharacterId(userCharacterId);
            equips.add(equip);
        }
        userCharacterEquipmentDao.saveAll(equips);
        return Result.success().message("角色捡起装备成功！");
    }

    @Override
    public Result changeEquipedEquip(ChangeEquipedCommand command) {
        UserCharacterEquipment equipment = null;
        CharacterEquipmentDto dto = null;
        if (null != command.getUnpackId()) {
            //取消装备
            userCharacterEquipmentDao.updateEquipedState(command.getUnpackId(), false);
            Optional<UserCharacterEquipment> op_equipment = userCharacterEquipmentDao.findById(command.getUnpackId());
            if (op_equipment.isPresent()) {
                equipment = op_equipment.get();
            }
        }
        if (null != command.getPackId()) {
            //进行装备
            //首先进行卸下相同部位的装备
            Optional<UserCharacterEquipment> op_equipment = userCharacterEquipmentDao.findById(command.getPackId());
            if (op_equipment.isPresent()) {
                equipment = op_equipment.get();
                userCharacterEquipmentDao.updateEquipedStateByType(equipment.getUserCharacterId(), equipment.getType(), false);
                userCharacterEquipmentDao.updateEquipedState(command.getPackId(), true);
            }
        }
        if (equipment != null) {
            dto = new CharacterEquipmentDto();
            BeanUtils.copyProperties(equipment, dto);
        }
        return Result.success().message("更换装备成功！").withData(dto);
    }

    @Override
    public Result delete(Long id) {
        userCharacterEquipmentDao.deleteById(id);
        return Result.success().message("删除该装备成功！");
    }

    //需要细化锁
    private synchronized Result upgrade(UserCharacterEquipment equipment) {
        Optional<UserCharacter> op_userCharacter = userCharacterDao.findById(equipment.getUserCharacterId());
        //传入装备的类型，不同类型的装备需要的装备券不一样
        LevelUpgradeContext levelContext = new LevelUpgradeContext(new EquipmentUpgradeStrategy(equipment.getType()));
        if (!op_userCharacter.isPresent()) {
            return Result.error().message("获取用户角色信息失败！");
        }
        UserCharacter userCharacter = op_userCharacter.get();

        Values<Integer> values = levelContext.execute(equipment.getUpgradeTimes(), userCharacter.getEquipmentCoupon());
        if (values.getLevel_or_upper().intValue() == equipment.getUpgradeTimes().intValue()) {
            return Result.error().message("装备券不足，无法升级该装备!");
        }
        equipment.setUpgradeTimes(values.getLevel_or_upper());
        userCharacter.setEquipmentCoupon(values.getCurrent());
        userCharacter.setModifyTime(new Date());
        //更新技能属性
        UpdateUtil.upgrade(equipment, equipment.getUpgradeTimes(), true, false);
        //更新两个对象
        userCharacterDao.save(userCharacter);
        userCharacterEquipmentDao.save(equipment);
        CharacterEquipmentDto dto = new CharacterEquipmentDto();
        BeanUtils.copyProperties(equipment, dto);
        return Result.success().message("装备升级成功！").withData(dto);
    }

    private List<EquipmentDto> getEquipmentDtos(List<Equipment> equipments) {
        List<EquipmentDto> dtos = equipments.stream().map(equip -> {
            EquipmentDto dto = new EquipmentDto();
            BeanUtils.copyProperties(equip, dto);
            return dto;
        }).collect(Collectors.toList());
        return dtos;
    }


    private List<CharacterEquipmentDto> getCharacterEquipmentDtos(List<UserCharacterEquipment> equipments) {
        List<CharacterEquipmentDto> dtos = equipments.stream().map(equip -> {
            CharacterEquipmentDto dto = new CharacterEquipmentDto();
            BeanUtils.copyProperties(equip, dto);
            return dto;
        }).collect(Collectors.toList());
        return dtos;
    }
}
