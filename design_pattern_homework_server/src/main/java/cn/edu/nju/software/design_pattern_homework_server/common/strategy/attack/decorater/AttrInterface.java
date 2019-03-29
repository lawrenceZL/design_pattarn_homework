package cn.edu.nju.software.design_pattern_homework_server.common.strategy.attack.decorater;

import cn.edu.nju.software.design_pattern_homework_server.common.strategy.attack.AttrCommand;
import lombok.Data;

@Data
public abstract class AttrInterface {

    private Double ATN = 0.0;
    //魔法攻击
    private Double INT = 0.0;
    //物理防御
    private Double DEF = 0.0;
    //魔法防御
    private Double RES = 0.0;
    //暴击率
    private Double CRIT = 0.0;
    //暴击伤害
    private Double CRIT_S = 0.0;
    //敏捷度
    private Double SPD = 0.0;

    public abstract AttrCommand obtainAttr();
}
