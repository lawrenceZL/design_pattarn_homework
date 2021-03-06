package cn.edu.nju.software.design_pattern_homework_server.dto;

import cn.edu.nju.software.design_pattern_homework_server.common.enumeration.SEX;
import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String username;
    private SEX sex;
    private String mail;
    private String tel;
}
