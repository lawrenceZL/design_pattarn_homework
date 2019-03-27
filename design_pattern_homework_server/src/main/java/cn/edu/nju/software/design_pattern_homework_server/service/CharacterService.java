package cn.edu.nju.software.design_pattern_homework_server.service;

import cn.edu.nju.software.design_pattern_homework_server.command.BindCharacterCommand;
import cn.edu.nju.software.design_pattern_homework_server.common.result.Result;

public interface CharacterService {
    Result bindCharacter(BindCharacterCommand command);

    Result getList();

    Result getUserCharacters(Long userId);

    Result getDetail();
}
