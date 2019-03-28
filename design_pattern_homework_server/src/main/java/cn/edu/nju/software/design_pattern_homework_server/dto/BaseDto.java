package cn.edu.nju.software.design_pattern_homework_server.dto;

import lombok.Data;

import java.util.Date;

@Data
public class BaseDto {

    private Long id;

    private Date createTime;

    private Date modifyTime;
}
