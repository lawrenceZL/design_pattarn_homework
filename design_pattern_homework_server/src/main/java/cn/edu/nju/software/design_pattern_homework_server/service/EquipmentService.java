package cn.edu.nju.software.design_pattern_homework_server.service;

import cn.edu.nju.software.design_pattern_homework_server.command.UpgradeCommand;
import cn.edu.nju.software.design_pattern_homework_server.common.result.Result;

public interface EquipmentService {

    Result getCharacterEquips(Long userCharacterId);

    Result getEquipedEquips(Long userCharacterId);

    Result getAllEuips();
    Result getMaxEquipId();
    Result getMinEquipId();
    Result getAllEquips(Long characterId);

    Result getAllEquips(Long userCharacterId, Boolean equiped);

    Result upgrade(UpgradeCommand command);
}
