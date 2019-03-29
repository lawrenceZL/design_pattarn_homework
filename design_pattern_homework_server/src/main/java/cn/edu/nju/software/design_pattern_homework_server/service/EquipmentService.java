package cn.edu.nju.software.design_pattern_homework_server.service;

import cn.edu.nju.software.design_pattern_homework_server.command.ChangeEquipedCommand;
import cn.edu.nju.software.design_pattern_homework_server.command.EquipCommand;
import cn.edu.nju.software.design_pattern_homework_server.command.UpgradeCommand;
import cn.edu.nju.software.design_pattern_homework_server.common.result.Result;

import java.util.List;

public interface EquipmentService {

    Result getCharacterEquips(Long userCharacterId);

    Result getEquipedEquips(Long userCharacterId);

    Result getAllEuips();
    Long getMaxEquipId();
    Long getMinEquipId();
    Result getAllEquips(Long characterId);

    Result getAllEquips(Long userCharacterId, Boolean equiped);

    Result upgrade(UpgradeCommand command);

    Result pickUpEquip(List<EquipCommand> equipments,Long userCharacterId);

    Result changeEquipedEquip(ChangeEquipedCommand command);

    Result delete(Long id);
}
