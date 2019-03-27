package cn.edu.nju.software.design_pattern_homework_server.command;

import cn.edu.nju.software.design_pattern_homework_server.common.enumeration.SEX;
import lombok.Data;

@Data
public class RegisterCommand {
    private String username;
    private String password;
    private SEX sex;
    private String mail;
    private String tel;
}
