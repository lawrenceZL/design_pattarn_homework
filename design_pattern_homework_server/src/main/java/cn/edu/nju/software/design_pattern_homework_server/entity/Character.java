package cn.edu.nju.software.design_pattern_homework_server.entity;

import cn.edu.nju.software.design_pattern_homework_server.entity.base.CharacterBaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "t_character")
@EqualsAndHashCode(callSuper = true)
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Character extends CharacterBaseEntity {
}
