package cn.edu.nju.software.design_pattern_homework_server.dto;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

@Data
public class CharacterDto extends AttrDto {

    private String name;
    private String enName;
    private Double currentEXP = 0.0;
    //经验上限
    @JSONField(name = "EXP")
    private Double EXP;
    //生命上限
    @JSONField(name = "HP")
    private Double HP;
    //魔力上限
    @JSONField(name = "MAG")
    private Double MAG;
    //初始等级(1级)
    private Integer level;

    private Integer weaponCoupon;

    private Integer equipmentCoupon;

    private Integer skillCoupon;
}
