package cn.edu.nju.software.design_pattern_homework_server.service;

import cn.edu.nju.software.design_pattern_homework_server.command.BindCharacterCommand;
import cn.edu.nju.software.design_pattern_homework_server.command.CharacterCommand;
import cn.edu.nju.software.design_pattern_homework_server.command.PickUpCommand;
import cn.edu.nju.software.design_pattern_homework_server.common.result.Result;

public interface CharacterService {
    Result bindCharacter(BindCharacterCommand command);

    Result getList();

    Result getUserCharacters(Long userId);

    Result getDetail(Long userCharacterId);

    Result getCharacterWeapon(Long userCharacterId);

    Result upgrade(CharacterCommand command);

    Result update(CharacterCommand command);

    Result pickUpThings(PickUpCommand command);

    Result dropOutThings();

    Result genGoblins(Long userCharacterId);

    Result getInfo(Long userCharacterId);
}
