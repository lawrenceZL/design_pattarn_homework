package cn.edu.nju.software.design_pattern_homework_server.dto;

import lombok.Data;

@Data
public class AttrDto {
    private Long id;
    //物理攻击
    private Double ATN;
    //魔法攻击
    private Double INT;
    //物理防御
    private Double DEF;
    //魔法防御
    private Double RES;
    //暴击率
    private Double CRIT;
    //暴击伤害
    private Double CRIT_S;
    //敏捷度
    private Double SPD;

}
