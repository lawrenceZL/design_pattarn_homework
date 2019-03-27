package cn.edu.nju.software.design_pattern_homework_server.entity;

import cn.edu.nju.software.design_pattern_homework_server.common.enumeration.EQUIP_LEVEL;
import cn.edu.nju.software.design_pattern_homework_server.common.enumeration.EQUIP_TYPE;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@Entity
@Table(name = "t_euqipment")
@EqualsAndHashCode(callSuper = true)
//这种继承策略，低冗余，查询需要表连接
//@Inheritance(strategy = InheritanceType.JOINED)
//这种继承策略，高冗余，查询无需表连接
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Equipment extends AttrBaseEntity {

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
