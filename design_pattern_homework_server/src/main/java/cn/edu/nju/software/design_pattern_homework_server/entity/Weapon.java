package cn.edu.nju.software.design_pattern_homework_server.entity;

import cn.edu.nju.software.design_pattern_homework_server.entity.base.AttrBaseEntity;
import cn.edu.nju.software.design_pattern_homework_server.entity.base.WeaponBaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@Entity
@Table(name = "t_weapon")
@EqualsAndHashCode(callSuper = true)
//这种继承策略，低冗余，查询需要表连接
//@Inheritance(strategy = InheritanceType.JOINED)
//这种继承策略，高冗余，查询无需表连接
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Weapon extends WeaponBaseEntity {
}