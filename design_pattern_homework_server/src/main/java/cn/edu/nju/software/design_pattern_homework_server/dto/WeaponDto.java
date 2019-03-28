package cn.edu.nju.software.design_pattern_homework_server.dto;

import lombok.Data;

@Data
public class WeaponDto extends AttrDto {
    private String name;
    private Double upgradeValueLimit;
    private Double upgradePercentLimit;
    private Long characterId;
}
