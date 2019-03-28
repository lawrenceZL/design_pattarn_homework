package cn.edu.nju.software.design_pattern_homework_server.dto;

import lombok.Data;

@Data
public class CharacterWeaponDto extends WeaponDto {

    private Long userCharacterId;

    private Integer upgradeTimes;

}
