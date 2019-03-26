package cn.edu.nju.software.design_pattern_homework_server.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "t_character")
@EqualsAndHashCode(callSuper = true)
public class Character extends AttrBaseEntity {
    @Column(name = "f_name")
    private String name;
    @Column(name = "f_en_name")
    private String enName;
    //经验上限
    @Column(name = "f_exp")
    private Double EXP;
    //生命上限
    @Column(name = "f_hp")
    private Double HP;
    //魔力上限
    @Column(name = "f_mag")
    private Double MAG;
    //初始等级(1级)
    @Column(name = "f_level")
    private Integer level;

}
