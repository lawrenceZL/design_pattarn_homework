package cn.edu.nju.software.design_pattern_homework_server.service.impl;

import cn.edu.nju.software.design_pattern_homework_server.command.UpgradeCommand;
import cn.edu.nju.software.design_pattern_homework_server.common.result.Result;
import cn.edu.nju.software.design_pattern_homework_server.dao.UserCharacterSkillRepository;
import cn.edu.nju.software.design_pattern_homework_server.dto.CharacterSkillDto;
import cn.edu.nju.software.design_pattern_homework_server.entity.UserCharacterSkill;
import cn.edu.nju.software.design_pattern_homework_server.service.SkillService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SkillServiceImpl implements SkillService {

    @Resource
    private UserCharacterSkillRepository userCharacterSkillDao;

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
        return null;
    }

}
