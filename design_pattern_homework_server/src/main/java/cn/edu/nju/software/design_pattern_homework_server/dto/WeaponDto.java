package cn.edu.nju.software.design_pattern_homework_server.dto;

import lombok.Data;

import javax.persistence.Column;

@Data
public class WeaponDto extends AttrDto {
    private String name;
//    private Double upgradeValueLimit;
//    private Double upgradePercentLimit;
    private Long characterId;

    private Integer upgradeTimes;
}
