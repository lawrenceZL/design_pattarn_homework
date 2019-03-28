package cn.edu.nju.software.design_pattern_homework_server.service;

import cn.edu.nju.software.design_pattern_homework_server.common.result.Result;

public interface SkillService {
    Result getCharacterSkills(Long userCharacterId);
}
