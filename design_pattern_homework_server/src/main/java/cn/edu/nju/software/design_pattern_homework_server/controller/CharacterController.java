package cn.edu.nju.software.design_pattern_homework_server.controller;

import cn.edu.nju.software.design_pattern_homework_server.command.BindCharacterCommand;
import cn.edu.nju.software.design_pattern_homework_server.command.CharacterCommand;
import cn.edu.nju.software.design_pattern_homework_server.command.PickUpCommand;
import cn.edu.nju.software.design_pattern_homework_server.common.result.Result;
import cn.edu.nju.software.design_pattern_homework_server.entity.Character;
import cn.edu.nju.software.design_pattern_homework_server.service.CharacterService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("character")
public class CharacterController {
    @Resource
    private CharacterService characterService;

    @PostMapping("bind")
    public Result bindCharacter(@RequestBody BindCharacterCommand command) {
        return characterService.bindCharacter(command);
    }

    @GetMapping("info/{userCharacterId}")
    public Result info(@PathVariable("userCharacterId") Long userCharacterId) {
        return characterService.getInfo(userCharacterId);
    }
    @GetMapping("list")
    //用于用户进行新建游戏的角色选择
    public Result list() {
        return characterService.getList();
    }

    @GetMapping("monentos/{userId}")
    public Result monentos(@PathVariable("userId") Long userId) {
        return characterService.getUserCharacters(userId);

    }

    @GetMapping("detail/{userCharacterId}")
    public Result detail(@PathVariable("userCharacterId") Long userCharacterId) {
        return characterService.getDetail(userCharacterId);
    }

    @PostMapping("upgrade")
    public Result upgrade(@RequestBody CharacterCommand command) {
        return characterService.upgrade(command);
    }

    @PostMapping("update")
    public Result update(@RequestBody CharacterCommand command){
        return characterService.update(command);

    }

    @PostMapping("pick")
    public Result pickUpThings(@RequestBody PickUpCommand command){
        return characterService.pickUpThings(command);
    }

    @PostMapping("drop")
    public Result dropOutThings(){
        return characterService.dropOutThings();
    }

    @GetMapping("goblin/{userCharacterId}")
    public Result generateGoblins(@PathVariable("userCharacterId")Long userCharacterId){
        return characterService.genGoblins(userCharacterId);
    }
}
