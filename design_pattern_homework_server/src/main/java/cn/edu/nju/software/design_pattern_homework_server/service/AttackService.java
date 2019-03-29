package cn.edu.nju.software.design_pattern_homework_server.service;

import cn.edu.nju.software.design_pattern_homework_server.command.AttackCommand;
import cn.edu.nju.software.design_pattern_homework_server.common.result.Result;

public interface AttackService {
    Result attack(AttackCommand command);
}
