package cn.edu.nju.software.design_pattern_homework_server.entity.base;


import cn.edu.nju.software.design_pattern_homework_server.common.enumeration.SKILL_LEVEL;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@Data
@EqualsAndHashCode(callSuper = true)
@MappedSuperclass
public class SkillBaseEntity extends AttrBaseEntity {
    @Column(name = "f_name")
    private String name;

    @Column(name = "f_character_id")
    private Long characterId;

    @Column(name = "f_skill_level")
    private SKILL_LEVEL skillLevel;
}
