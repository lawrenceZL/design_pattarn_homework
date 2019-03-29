package cn.edu.nju.software.design_pattern_homework_server.service.impl;

import cn.edu.nju.software.design_pattern_homework_server.command.BindCharacterCommand;
import cn.edu.nju.software.design_pattern_homework_server.command.CharacterCommand;
import cn.edu.nju.software.design_pattern_homework_server.command.PickUpCommand;
import cn.edu.nju.software.design_pattern_homework_server.common.enumeration.EQUIP_TYPE;
import cn.edu.nju.software.design_pattern_homework_server.common.enumeration.SKILL_LEVEL;
import cn.edu.nju.software.design_pattern_homework_server.common.factory.GoblinContext;
import cn.edu.nju.software.design_pattern_homework_server.common.result.Result;
import cn.edu.nju.software.design_pattern_homework_server.common.strategy.Values;
import cn.edu.nju.software.design_pattern_homework_server.common.strategy.value.character.CharacterUpgradeContext;
import cn.edu.nju.software.design_pattern_homework_server.common.strategy.value.character.EXPUpgradeStrategy;
import cn.edu.nju.software.design_pattern_homework_server.common.strategy.value.character.HPUpgradeStrategy;
import cn.edu.nju.software.design_pattern_homework_server.common.strategy.value.character.MAGUpgradeStrategy;
import cn.edu.nju.software.design_pattern_homework_server.dao.*;
import cn.edu.nju.software.design_pattern_homework_server.dto.*;
import cn.edu.nju.software.design_pattern_homework_server.entity.Character;
import cn.edu.nju.software.design_pattern_homework_server.entity.*;
import cn.edu.nju.software.design_pattern_homework_server.service.CharacterService;
import cn.edu.nju.software.design_pattern_homework_server.service.EquipmentService;
import cn.edu.nju.software.design_pattern_homework_server.service.SkillService;
import cn.edu.nju.software.design_pattern_homework_server.util.RandomUtil;
import cn.edu.nju.software.design_pattern_homework_server.util.UpdateUtil;
import com.google.common.collect.Lists;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CharacterServiceImpl implements CharacterService {

    private static final int INIT_LEVEL = 0;
    @Resource
    private CharacterRepository characterDao;
    @Resource
    private UserCharacterRepository userCharacterDao;
    @Resource
    private WeaponRepository weaponDao;
    @Resource
    private UserCharacterWeaponRepository userCharacterWeaponDao;
    @Resource
    private SkillRepository skillDao;
    @Resource
    private UserCharacterSkillRepository userCharacterSkillDao;

    @Resource
    private EquipmentRepository equipmentDao;
    @Resource
    private SkillService skillService;

    @Resource
    private EquipmentService equipmentService;

    @Resource
    private GoblinContext goblinContext;

    @Resource
    private RandomUtil randomUtil;

    @Override
    public Result bindCharacter(BindCharacterCommand command) {
        Date date = new Date();
        Character character = characterDao.findFirstById(command.getCharacterId());
        Weapon weapon = weaponDao.findByCharacterId(command.getCharacterId());
        UserCharacterWeapon userCharacterWeapon = new UserCharacterWeapon();
        //存储用户角色的weapon信息，初始化
        BeanUtils.copyProperties(weapon, userCharacterWeapon, "id");
        userCharacterWeapon.setWeaponId(weapon.getId());
        userCharacterWeapon.setUpgradeTimes(INIT_LEVEL);
        userCharacterWeapon.setCreateTime(date);
        userCharacterWeapon = userCharacterWeaponDao.save(userCharacterWeapon);
        UserCharacter userCharacter = new UserCharacter();
        BeanUtils.copyProperties(character, userCharacter, "id");
        BeanUtils.copyProperties(command, userCharacter);
        userCharacter.setCreateTime(date);
        userCharacter.setCurrentEXP(userCharacter.getEXP());
        userCharacter.setCurrentHP(userCharacter.getHP());
        userCharacter.setCurrentMAG(userCharacter.getMAG());
        userCharacter.setUserCharacterWeaponId(userCharacterWeapon.getId());
        //创建用户角色信息
        userCharacter = userCharacterDao.save(userCharacter);
        //绑定weapon
        userCharacterWeapon.setUserCharacterId(userCharacter.getId());
        userCharacterWeaponDao.save(userCharacterWeapon);
        //绑定角色技能
        List<Skill> skills = skillDao.findAllByCharacterId(command.getCharacterId());
        List<UserCharacterSkill> userCharacterSkills = Lists.newArrayList();
        for (Skill skill : skills) {
            UserCharacterSkill userCharacterSkill = new UserCharacterSkill();
            BeanUtils.copyProperties(skill, userCharacterSkill, "id");
            userCharacterSkill.setCreateTime(date);
            userCharacterSkill.setSkillId(skill.getId());
            userCharacterSkill.setUserCharacterId(userCharacter.getId());
            //userCharacterSkill.setUpgradeTimes(INIT_LEVEL);
            userCharacterSkill.setSkillLevel(SKILL_LEVEL.NOT_LEARN);
            userCharacterSkills.add(userCharacterSkill);
        }
        userCharacterSkillDao.saveAll(userCharacterSkills);
        return Result.success().message("初始化绑定选择角色成功！").withData(userCharacter);
    }

    @Override
    public Result getList() {
        List<Character> characters = Lists.newArrayList(characterDao.findAll());
        List<CharacterDto> dtos = characters.stream().map(c -> {
            CharacterDto dto = new CharacterDto();
            BeanUtils.copyProperties(c, dto);
            return dto;
        }).collect(Collectors.toList());
        return Result.success().message("查询角色列表成功").withData(dtos);
    }

    @Override
    public Result getUserCharacters(Long userId) {
        List<UserCharacter> userCharacters = userCharacterDao.findAllByUserId(userId);
        List<UserCharacterDto> dtos = userCharacters.stream().map(uc -> {
            UserCharacterDto dto = new UserCharacterDto();
            BeanUtils.copyProperties(uc, dto);
            return dto;
        }).collect(Collectors.toList());
        return Result.success().withData(dtos).message("获取用户存档信息成功！");
    }

    @Override
    public Result getDetail(Long userCharacterId) {
        Optional<UserCharacter> userCharacter = userCharacterDao.findById(userCharacterId);
        if (userCharacter.isPresent()) {
            UserCharacterDetailDto dto = new UserCharacterDetailDto();
            //技能
            Result result = skillService.getCharacterSkills(userCharacterId);
            if (result.isSuccess()) {
                dto.setSkills((List<CharacterSkillDto>) result.getData());
            }
            //装备
            result = getCharacterWeapon(userCharacterId);
            if (result.isSuccess()) {
                dto.setWeapon((CharacterWeaponDto) result.getData());
            }
            result = equipmentService.getEquipedEquips(userCharacterId);
            if (result.isSuccess()) {
                Map<EQUIP_TYPE, CharacterEquipmentDto> dtos = (Map<EQUIP_TYPE, CharacterEquipmentDto>) result.getData();
                dtos.forEach((type, data) -> dto.pushEquipment(data));
            }
            return Result.success().message("获取用户细节成功！").withData(dto);

        }
        return Result.error().message("暂无用户角色信息！");
    }

    @Override
    public Result getCharacterWeapon(Long userCharacterId) {
        UserCharacterWeapon userCharacterWeapon = userCharacterWeaponDao.findByUserCharacterId(userCharacterId);
        CharacterWeaponDto dto = new CharacterWeaponDto();
        BeanUtils.copyProperties(userCharacterWeapon, dto);
        return Result.success().withData(dto);
    }

    @Override
    public Result upgrade(CharacterCommand command) {
        Optional<UserCharacter> op_character = userCharacterDao.findById(command.getId());
        if (!op_character.isPresent()) {
            return Result.error().message("获取用户角色信息失败！");
        }
        UserCharacter character = op_character.get();
        BeanUtils.copyProperties(command, character);
        return upgrade(character);
    }

    //需要细化锁
    private synchronized Result upgrade(UserCharacter character) {

        CharacterUpgradeContext characterContext = new CharacterUpgradeContext(new EXPUpgradeStrategy());
        Values<Double> values = characterContext.execute(character.getLevel(), character.getEXP(), character.getCurrentEXP());
        if (values.getLevel_or_upper().intValue() == character.getEXP()) {
            return Result.error().message("经验不足，角色无法升级!");
        }
        character.setEXP(values.getLevel_or_upper());
        character.setCurrentEXP(values.getCurrent());
        //更新用户血条
        characterContext = new CharacterUpgradeContext(new HPUpgradeStrategy());
        values = characterContext.execute(character.getLevel(), character.getHP(), character.getCurrentEXP());
        character.setHP(values.getLevel_or_upper());
        character.setCurrentHP(values.getCurrent());
        //更新用户蓝条
        characterContext = new CharacterUpgradeContext(new MAGUpgradeStrategy());
        values = characterContext.execute(character.getLevel(), character.getMAG(), character.getCurrentMAG());
        character.setMAG(values.getLevel_or_upper());
        character.setCurrentMAG(values.getCurrent());
        //更新用户等级
        character.setLevel(character.getLevel() + 1);
        //更新用户属性
        UpdateUtil.upgrade(character, character.getLevel(), false, true);
        //更新UserCharacter对象
        userCharacterDao.save(character);
        //返回数据
        UserCharacterDto dto = new UserCharacterDto();
        BeanUtils.copyProperties(character, dto);
        return Result.success().message("用户角色升级成功！").withData(dto);
    }

    @Override
    public Result update(CharacterCommand command) {
        Optional<UserCharacter> op_character = userCharacterDao.findById(command.getId());
        if (!op_character.isPresent()) {
            return Result.error().message("用户信息不存在！");
        }
        UserCharacter userCharacter = op_character.get();
        userCharacterDao.save(userCharacter);
        UserCharacterDto dto = new UserCharacterDto();
        BeanUtils.copyProperties(userCharacter, dto);
        return Result.success().message("更新用户角色信息成功！").withData(dto);
    }

    @Override
    public Result pickUpThings(PickUpCommand command) {
        //捡装备
        equipmentService.pickUpEquip(command.getEquipments(), command.getUserCharacterId());
        Optional<UserCharacter> op_character = userCharacterDao.findById(command.getUserCharacterId());
        Result part_result_2 = Result.error();
        if (!op_character.isPresent()) {
            return part_result_2.code(501).message("拾起装备成功，后添加升级券失败！");
        }
        UserCharacter character = op_character.get();
        character.setWeaponCoupon(character.getWeaponCoupon() + command.getWeaponCoupon());
        character.setEquipmentCoupon(character.getEquipmentCoupon() + command.getEquipmentCoupon());
        userCharacterDao.save(character);
        return Result.success().message("捡起物品成功！");
    }

    @Override
    public Result dropOutThings() {
        List<EquipmentDto> dtos = Lists.newArrayList();
        int max_coupon = 5;
        int max_equips = 2;
        long max = equipmentService.getMaxEquipId();
        long min = equipmentService.getMinEquipId();
        int weapon_coupon = randomUtil.randomRange(max_coupon);
        int equipment_coupon = randomUtil.randomRange(max_coupon);
        long id = randomUtil.random(min, max);
        if (randomUtil.random(0, max_equips) >= 1) {
            Optional<Equipment> op_equip = equipmentDao.findById(id);
            if (op_equip.isPresent()) {
                EquipmentDto dto = new EquipmentDto();
                BeanUtils.copyProperties(op_equip.get(), dto);
                dtos.add(dto);
            }
        }
        DroppedDto droppedDto = new DroppedDto();
        droppedDto.setEquipmentCoupon(equipment_coupon);
        droppedDto.setWeaponCoupon(weapon_coupon);
        droppedDto.setEquipments(dtos);
        return Result.success().message("随机掉落装备，升级券等成功！").withData(droppedDto);
    }

    @Override
    public Result genGoblins(Long userCharacterId) {
        Optional<UserCharacter> character = userCharacterDao.findById(userCharacterId);
        if (character.isPresent()) {
            return Result.success().message("随机生成哥布林成功！").withData(goblinContext.generate(character.get()));
        }
        return Result.error().message("获取用户角色信息失败！");
    }

    @Override
    public Result getInfo(Long userCharacterId) {
        Optional<UserCharacter> op_character = userCharacterDao.findById(userCharacterId);
        if (op_character.isPresent()) {
            UserCharacter character = op_character.get();
            UserCharacterDto dto = new UserCharacterDto();
            BeanUtils.copyProperties(character, dto);
            return Result.success().message("获取用户信息成功！").withData(dto);
        }
        return Result.error().message("获取用户信息失败！");
    }


}
