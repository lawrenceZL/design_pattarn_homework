package cn.edu.nju.software.design_pattern_homework_server.controller;

import cn.edu.nju.software.design_pattern_homework_server.command.AttackCommand;
import cn.edu.nju.software.design_pattern_homework_server.common.result.Result;
import cn.edu.nju.software.design_pattern_homework_server.service.AttackService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("attack")
public class AttackController {
    @Resource
    private AttackService attackService;

    @PostMapping
    public Result attack(@RequestBody AttackCommand command) {
        return attackService.attack(command);
    }
}
