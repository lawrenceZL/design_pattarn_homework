package cn.edu.nju.software.design_pattern_homework_server.service.impl;

import cn.edu.nju.software.design_pattern_homework_server.command.BindCharacterCommand;
import cn.edu.nju.software.design_pattern_homework_server.common.result.Result;
import cn.edu.nju.software.design_pattern_homework_server.dao.*;
import cn.edu.nju.software.design_pattern_homework_server.dto.CharacterDto;
import cn.edu.nju.software.design_pattern_homework_server.entity.Character;
import cn.edu.nju.software.design_pattern_homework_server.entity.*;
import cn.edu.nju.software.design_pattern_homework_server.service.CharacterService;
import com.google.common.collect.Lists;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
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
        return null;
    }

    @Override
    public Result getDetail() {
        return null;
    }
}
