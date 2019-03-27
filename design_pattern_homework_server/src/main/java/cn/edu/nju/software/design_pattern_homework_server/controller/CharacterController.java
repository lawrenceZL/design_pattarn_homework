package cn.edu.nju.software.design_pattern_homework_server.controller;

import cn.edu.nju.software.design_pattern_homework_server.command.BindCharacterCommand;
import cn.edu.nju.software.design_pattern_homework_server.common.result.Result;
import cn.edu.nju.software.design_pattern_homework_server.dao.CharacterRepository;
import cn.edu.nju.software.design_pattern_homework_server.dao.UserCharacterRepository;
import cn.edu.nju.software.design_pattern_homework_server.entity.Character;
import cn.edu.nju.software.design_pattern_homework_server.service.CharacterService;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("character")
public class CharacterController {
    @Resource
    private CharacterService characterService;
    @PostMapping("bind")
    public Result bindCharacter(@RequestBody BindCharacterCommand command){
        return characterService.bindCharacter(command);
    }

    @GetMapping("list")
    public Result list(){
        return characterService.getList();
    }

    @GetMapping("monentos/{userId}")
    public Result monentos(@PathVariable("userId")Long userId){
        return characterService.getUserCharacters(userId);

    }

    @GetMapping("detail/{userCharacterId}")
    public Result detail(@PathVariable("userCharacterId")Long userCharacterId){
        return characterService.getDetail();
    }
}
