package cn.edu.nju.software.design_pattern_homework_server.service;

import cn.edu.nju.software.design_pattern_homework_server.command.UpgradeCommand;
import cn.edu.nju.software.design_pattern_homework_server.common.result.Result;

public interface WeaponService {
    Result getWeapon(Long userCharacterId);

    Result upgrade(UpgradeCommand command);
}
