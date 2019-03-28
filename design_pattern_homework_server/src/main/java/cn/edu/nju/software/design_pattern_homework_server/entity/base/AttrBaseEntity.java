package cn.edu.nju.software.design_pattern_homework_server.entity.base;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;


@Data
@EqualsAndHashCode(callSuper = true)
@MappedSuperclass
public abstract class AttrBaseEntity extends BaseEntity {

    //物理攻击
    @Column(name = "f_atn")
    private Double ATN;
    //魔法攻击
    @Column(name = "f_int")
    private Double INT;
    //物理防御
    @Column(name = "f_def")
    private Double DEF;
    //魔法防御
    @Column(name = "f_res")
    private Double RES;
    //暴击率
    @Column(name = "f_crit")
    private Double CRIT;
    //暴击伤害
    @Column(name = "f_crit_s")
    private Double CRIT_S;
    //敏捷度
    @Column(name = "f_spd")
    private Double SPD;


}
