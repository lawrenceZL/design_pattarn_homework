package cn.edu.nju.software.design_pattern_homework_server.command;

import lombok.Data;

@Data
public class LoginCommand {
    private String username;
    private String password;
}
