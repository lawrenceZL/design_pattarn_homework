package cn.edu.nju.software.design_pattern_homework_server.controller;

import cn.edu.nju.software.design_pattern_homework_server.command.UpgradeCommand;
import cn.edu.nju.software.design_pattern_homework_server.common.result.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("skill")
public class SkillController {


    @PostMapping("upgrade")
    public Result upgrade(@RequestBody UpgradeCommand command){
        return null;
    }
}
