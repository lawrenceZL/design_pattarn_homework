package cn.edu.nju.software.design_pattern_homework_server.service.impl;

import cn.edu.nju.software.design_pattern_homework_server.command.BindCharacterCommand;
import cn.edu.nju.software.design_pattern_homework_server.common.enumeration.SKILL_LEVEL;
import cn.edu.nju.software.design_pattern_homework_server.common.result.Result;
import cn.edu.nju.software.design_pattern_homework_server.dao.*;
import cn.edu.nju.software.design_pattern_homework_server.dto.*;
import cn.edu.nju.software.design_pattern_homework_server.entity.Character;
import cn.edu.nju.software.design_pattern_homework_server.entity.*;
import cn.edu.nju.software.design_pattern_homework_server.service.CharacterService;
import cn.edu.nju.software.design_pattern_homework_server.service.EquipmentService;
import cn.edu.nju.software.design_pattern_homework_server.service.SkillService;
import com.google.common.collect.Lists;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
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
    private SkillService skillService;

    @Resource
    private EquipmentService equipmentService;

    @Override
    public Result bindCharacter(BindCharacterCommand command) {
        Character character = characterDao.findFirstById(command.getCharacterId());
        Weapon weapon = weaponDao.findByCharacterId(command.getCharacterId());
        UserCharacterWeapon userCharacterWeapon = new UserCharacterWeapon();
        //存储用户角色的weapon信息，初始化
        BeanUtils.copyProperties(weapon, userCharacterWeapon, "id");
        userCharacterWeapon.setUpgradeTimes(INIT_LEVEL);
        userCharacterWeapon = userCharacterWeaponDao.save(userCharacterWeapon);
        UserCharacter userCharacter = new UserCharacter();
        BeanUtils.copyProperties(character, userCharacter, "id");
        userCharacter.setNickname(command.getNickname());
        userCharacter.setUserId(command.getUserId());
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
            userCharacterSkill.setUserCharacterId(userCharacter.getId());
            userCharacterSkill.setUpgradeTimes(INIT_LEVEL);
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
                List<CharacterEquipmentDto> dtos = (List<CharacterEquipmentDto>) result.getData();
                for (CharacterEquipmentDto equip : dtos) {
                    dto.pushEquipment(equip);
                }
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


}
