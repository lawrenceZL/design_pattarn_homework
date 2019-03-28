package cn.edu.nju.software.design_pattern_homework_server.controller;

import cn.edu.nju.software.design_pattern_homework_server.command.UpgradeCommand;
import cn.edu.nju.software.design_pattern_homework_server.common.result.Result;
import cn.edu.nju.software.design_pattern_homework_server.service.SkillService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("skill")
public class SkillController {
    @Resource
    private SkillService skillService;

    @GetMapping("/{userCharacterId}")
    public Result skills(@PathVariable("userCharacterId") Long userCharacterId) {
        return skillService.getCharacterSkills(userCharacterId);
    }


    @PostMapping("upgrade")
    public Result upgrade(@RequestBody UpgradeCommand command) {
        //TODO
        return skillService.upgrade(command);
    }
}
