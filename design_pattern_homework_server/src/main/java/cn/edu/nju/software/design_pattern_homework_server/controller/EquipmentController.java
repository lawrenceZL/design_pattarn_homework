package cn.edu.nju.software.design_pattern_homework_server.controller;

import cn.edu.nju.software.design_pattern_homework_server.command.ChangeEquipedCommand;
import cn.edu.nju.software.design_pattern_homework_server.command.EquipCommand;
import cn.edu.nju.software.design_pattern_homework_server.command.PickUpCommand;
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
        return equipmentService.upgrade(command);
    }

    @PostMapping("pick")
    public Result pickUpEquip(@RequestBody PickUpCommand command){
        return equipmentService.pickUpEquip(command.getEquipments(),command.getUserCharacterId());
    }

    @PostMapping("change")
    public Result equipedEquip(@RequestBody ChangeEquipedCommand command){
        return equipmentService.changeEquipedEquip(command);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable("id")Long id){
        return equipmentService.delete(id);
    }
}
