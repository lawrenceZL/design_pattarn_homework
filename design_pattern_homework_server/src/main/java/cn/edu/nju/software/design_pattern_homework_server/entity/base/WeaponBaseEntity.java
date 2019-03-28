package cn.edu.nju.software.design_pattern_homework_server.entity.base;


import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@Data
@EqualsAndHashCode(callSuper = true)
@MappedSuperclass
public class WeaponBaseEntity extends AttrBaseEntity {

    @Column(name = "f_name")
    private String name;
    @Column(name = "f_upgrade_value_limit")
    private Double upgradeValueLimit;
    @Column(name = "f_upgrade_percent_limit")
    private Double upgradePercentLimit;

    @Column(name = "f_character_id")
    private Long characterId;

    @Column(name = "f_update_times")
    private Integer upgradeTimes = 0;
}
