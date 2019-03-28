package cn.edu.nju.software.design_pattern_homework_server.entity;

import cn.edu.nju.software.design_pattern_homework_server.common.enumeration.SKILL_LEVEL;
import cn.edu.nju.software.design_pattern_homework_server.entity.base.AttrBaseEntity;
import cn.edu.nju.software.design_pattern_homework_server.entity.base.SkillBaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@Entity
@Table(name = "t_skill")
@EqualsAndHashCode(callSuper = true)
public class Skill extends SkillBaseEntity {
}