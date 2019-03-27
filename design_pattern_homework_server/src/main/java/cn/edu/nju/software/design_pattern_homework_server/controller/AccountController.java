package cn.edu.nju.software.design_pattern_homework_server.controller;


import cn.edu.nju.software.design_pattern_homework_server.command.LoginCommand;
import cn.edu.nju.software.design_pattern_homework_server.command.RegisterCommand;
import cn.edu.nju.software.design_pattern_homework_server.common.result.Result;
import cn.edu.nju.software.design_pattern_homework_server.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Resource
    private AccountService accountService;

    @PostMapping("register")
    public Result register(@RequestBody RegisterCommand command){
        return accountService.register(command);
    }

    @PostMapping("login")
    public Result login(@RequestBody LoginCommand command){
        return accountService.login(command);
    }
}
