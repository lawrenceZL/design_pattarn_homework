package cn.edu.nju.software.design_pattern_homework_server.service.impl;

import cn.edu.nju.software.design_pattern_homework_server.command.UpgradeCommand;
import cn.edu.nju.software.design_pattern_homework_server.common.enumeration.EQUIP_TYPE;
import cn.edu.nju.software.design_pattern_homework_server.common.result.Result;
import cn.edu.nju.software.design_pattern_homework_server.dao.EquipmentRepository;
import cn.edu.nju.software.design_pattern_homework_server.dao.UserCharacterEquipmentRepository;
import cn.edu.nju.software.design_pattern_homework_server.dto.CharacterEquipmentDto;
import cn.edu.nju.software.design_pattern_homework_server.dto.EquipmentDto;
import cn.edu.nju.software.design_pattern_homework_server.entity.Equipment;
import cn.edu.nju.software.design_pattern_homework_server.entity.UserCharacterEquipment;
import cn.edu.nju.software.design_pattern_homework_server.service.EquipmentService;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EquipmentServiceImpl implements EquipmentService {

    @Resource
    private EquipmentRepository equipmentDao;
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
    public Result getMaxEquipId() {
        return Result.success().withData(equipmentDao.maxId());
    }

    @Override
    public Result getMinEquipId() {
        return Result.success().withData(equipmentDao.minId());
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
        return getAllEquips(userCharacterId);
    }

    @Override
    public Result upgrade(UpgradeCommand command) {
        return null;
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
