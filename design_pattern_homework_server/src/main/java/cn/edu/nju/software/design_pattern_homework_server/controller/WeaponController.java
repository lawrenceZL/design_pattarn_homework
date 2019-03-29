package cn.edu.nju.software.design_pattern_homework_server.controller;


import cn.edu.nju.software.design_pattern_homework_server.command.UpgradeCommand;
import cn.edu.nju.software.design_pattern_homework_server.common.result.Result;
import cn.edu.nju.software.design_pattern_homework_server.entity.Weapon;
import cn.edu.nju.software.design_pattern_homework_server.service.CharacterService;
import cn.edu.nju.software.design_pattern_homework_server.service.WeaponService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("weapon")
public class WeaponController {

    @Resource
    private WeaponService weaponService;

    @GetMapping("/{userCharacterId}")
    public Result skills(@PathVariable("userCharacterId") Long userCharacterId) {
        return weaponService.getWeapon(userCharacterId);
    }

    @PostMapping("upgrade")
    public Result upgrade(@RequestBody UpgradeCommand command) {
        return weaponService.upgrade(command);
    }
}
