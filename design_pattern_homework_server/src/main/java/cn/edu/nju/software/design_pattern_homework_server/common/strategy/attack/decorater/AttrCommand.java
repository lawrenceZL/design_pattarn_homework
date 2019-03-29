package cn.edu.nju.software.design_pattern_homework_server.common.strategy.attack.decorater;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AttrCommand {
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
