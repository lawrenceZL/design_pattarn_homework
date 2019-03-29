package cn.edu.nju.software.design_pattern_homework_server.service.impl;

import cn.edu.nju.software.design_pattern_homework_server.command.UpgradeCommand;
import cn.edu.nju.software.design_pattern_homework_server.common.enumeration.SKILL_LEVEL;
import cn.edu.nju.software.design_pattern_homework_server.common.result.Result;
import cn.edu.nju.software.design_pattern_homework_server.common.strategy.Values;
import cn.edu.nju.software.design_pattern_homework_server.common.strategy.level.LevelUpgradeContext;
import cn.edu.nju.software.design_pattern_homework_server.common.strategy.level.SkillUpgradeStrategy;
import cn.edu.nju.software.design_pattern_homework_server.dao.UserCharacterRepository;
import cn.edu.nju.software.design_pattern_homework_server.dao.UserCharacterSkillRepository;
import cn.edu.nju.software.design_pattern_homework_server.dto.CharacterSkillDto;
import cn.edu.nju.software.design_pattern_homework_server.entity.UserCharacter;
import cn.edu.nju.software.design_pattern_homework_server.entity.UserCharacterSkill;
import cn.edu.nju.software.design_pattern_homework_server.service.SkillService;
import cn.edu.nju.software.design_pattern_homework_server.util.UpdateUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SkillServiceImpl implements SkillService {

    @Resource
    private UserCharacterSkillRepository userCharacterSkillDao;
    @Resource
    private UserCharacterRepository userCharacterDao;

    @Override
    public Result getCharacterSkills(Long userCharacterId) {
        //技能
        List<UserCharacterSkill> skillList = userCharacterSkillDao.findAllByUserCharacterId(userCharacterId);
        List<CharacterSkillDto> skills = skillList.stream().map(skill -> {
            CharacterSkillDto skillDto = new CharacterSkillDto();
            BeanUtils.copyProperties(skill, skillDto);
            return skillDto;
        }).collect(Collectors.toList());
        return Result.success().message("获取当前角色的技能信息成功！").withData(skills);
    }

    @Override
    public Result upgrade(UpgradeCommand command) {
        Optional<UserCharacterSkill> op_skill = userCharacterSkillDao.findById(command.getId());
        if (!op_skill.isPresent()) {
            return Result.error().message("技能信息不存在！");
        }
        UserCharacterSkill skill = op_skill.get();
        return upgrade(skill);
    }

    //需要细化锁
    private synchronized Result upgrade(UserCharacterSkill skill) {
        if (skill.getSkillLevel().ordinal() == SKILL_LEVEL.values().length - 1) {
            return Result.error().message("该技能已经达到最高熟练度，无法升级！");
        }
        Optional<UserCharacter> op_userCharacter = userCharacterDao.findById(skill.getUserCharacterId());
        LevelUpgradeContext levelContext = new LevelUpgradeContext(new SkillUpgradeStrategy());
        if (!op_userCharacter.isPresent()) {
            return Result.error().message("获取用户角色信息失败！");
        }
        UserCharacter userCharacter = op_userCharacter.get();

        Values<Integer> values = levelContext.execute(skill.getSkillLevel().ordinal(), userCharacter.getSkillCoupon());
        if (values.getLevel_or_upper() == skill.getSkillLevel().ordinal()) {
            return Result.error().message("技能点不足，无法升级该技能!");
        }
        userCharacter.setSkillCoupon(values.getCurrent());
        userCharacter.setModifyTime(new Date());
        //更新技能属性
        UpdateUtil.upgrade(skill, skill.getSkillLevel().ordinal(), false, false);
        //更新两个对象
        userCharacterDao.save(userCharacter);
        userCharacterSkillDao.save(skill);

        CharacterSkillDto dto = new CharacterSkillDto();
        BeanUtils.copyProperties(skill, dto);
        return Result.success().message("技能升级成功！").withData(dto);
    }

}
