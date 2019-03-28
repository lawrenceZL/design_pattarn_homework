package cn.edu.nju.software.design_pattern_homework_server.dto;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

@Data
public class AttrDto {
    private Long id;
    //物理攻击
    @JSONField(name = "ATN")
    private Double ATN;
    //魔法攻击
    @JSONField(name = "INT")
    private Double INT;
    //物理防御
    @JSONField(name = "DEF")
    private Double DEF;
    //魔法防御
    @JSONField(name = "RES")
    private Double RES;
    //暴击率
    @JSONField(name = "CRIT")
    private Double CRIT;
    //暴击伤害
    @JSONField(name = "CRIT_S")
    private Double CRIT_S;
    //敏捷度
    @JSONField(name = "SPD")
    private Double SPD;

}
