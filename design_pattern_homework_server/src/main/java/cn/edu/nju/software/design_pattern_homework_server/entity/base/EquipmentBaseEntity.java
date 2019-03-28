package cn.edu.nju.software.design_pattern_homework_server.entity.base;

import cn.edu.nju.software.design_pattern_homework_server.common.enumeration.EQUIP_LEVEL;
import cn.edu.nju.software.design_pattern_homework_server.common.enumeration.EQUIP_TYPE;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@Data
@EqualsAndHashCode(callSuper = true)
@MappedSuperclass
public class EquipmentBaseEntity extends AttrBaseEntity {
    @Column(name = "f_type")
    private EQUIP_TYPE type;

    @Column(name = "f_level")
    private EQUIP_LEVEL level;
    @Column(name = "f_name")
    private String name;
    @Column(name = "f_upgrade_value_limit")
    private Double upgradeValueLimit;
    @Column(name = "f_upgrade_percent_limit")
    private Double upgradePercentLimit;

    @Column(name = "f_character_id")
    private Long characterId;

}
