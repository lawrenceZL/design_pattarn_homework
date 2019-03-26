package cn.edu.nju.software.design_pattern_homework_server.entity;

import cn.edu.nju.software.design_pattern_homework_server.common.enumeration.SKILL_LEVEL;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@Entity
@Table(name = "t_skill")
@EqualsAndHashCode(callSuper = true)
//这种继承策略，低冗余，查询需要表连接
//@Inheritance(strategy = InheritanceType.JOINED)
//这种继承策略，高冗余，查询无需表连接
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Skill extends AttrBaseEntity {
    @Column(name = "f_name")
    private String name;

    @Column(name = "f_character_id")
    private Long characterId;

    @Column(name = "f_skill_level")
    private SKILL_LEVEL skillLevel;


}