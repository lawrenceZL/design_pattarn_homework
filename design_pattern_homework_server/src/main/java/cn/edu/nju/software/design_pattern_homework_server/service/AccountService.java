package cn.edu.nju.software.design_pattern_homework_server.service;

import cn.edu.nju.software.design_pattern_homework_server.command.LoginCommand;
import cn.edu.nju.software.design_pattern_homework_server.command.RegisterCommand;
import cn.edu.nju.software.design_pattern_homework_server.common.result.Result;

public interface AccountService {
    Result register(RegisterCommand command);

    Result login(LoginCommand command);
}
