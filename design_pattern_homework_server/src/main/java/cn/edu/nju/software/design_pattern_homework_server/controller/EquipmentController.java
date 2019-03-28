package cn.edu.nju.software.design_pattern_homework_server.controller;

import cn.edu.nju.software.design_pattern_homework_server.command.UpgradeCommand;
import cn.edu.nju.software.design_pattern_homework_server.common.result.Result;
import cn.edu.nju.software.design_pattern_homework_server.service.EquipmentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("equip")
public class EquipmentController {
    @Resource
    private EquipmentService equipmentService;

    @GetMapping("max")
    public Result getMaxId() {
        return equipmentService.getMaxEquipId();
    }


    //true当前角色已经装备的装备 map
    //false当前角色的装备库 list
    @GetMapping
    public Result getEquips(@RequestParam("userCharacterId") Long userCharacterId, @RequestParam("equiped") Boolean equiped) {
        return equipmentService.getAllEquips(userCharacterId, equiped);
    }


    @PostMapping("upgrade")
    public Result upgrade(@RequestBody UpgradeCommand command){
        //TODO
        return equipmentService.upgrade(command);
    }
}
