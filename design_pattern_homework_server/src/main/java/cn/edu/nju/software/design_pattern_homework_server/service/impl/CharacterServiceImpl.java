package cn.edu.nju.software.design_pattern_homework_server.service.impl;

import cn.edu.nju.software.design_pattern_homework_server.command.BindCharacterCommand;
import cn.edu.nju.software.design_pattern_homework_server.common.result.Result;
import cn.edu.nju.software.design_pattern_homework_server.service.CharacterService;
import org.springframework.stereotype.Service;

@Service
public class CharacterServiceImpl implements CharacterService {
    @Override
    public Result bindCharacter(BindCharacterCommand command) {
        return null;
    }

    @Override
    public Result getList() {
        return null;
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
