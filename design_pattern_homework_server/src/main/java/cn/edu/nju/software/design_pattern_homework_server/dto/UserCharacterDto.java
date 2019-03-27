package cn.edu.nju.software.design_pattern_homework_server.dto;

import cn.edu.nju.software.design_pattern_homework_server.common.component.AttrComponent;
import lombok.Data;

@Data
public class UserCharacterDto extends CharacterDto implements AttrComponent {

    private Long id;
    private Long userId;
    private Long characterId;
    private String nickname;
    //经验上限
    private Double EXP;
    //生命上限
    private Double HP;
    //魔力上限
    private Double MAG;
    //初始等级(1级)
    private Integer level;


    @Override
    public AttrDto totalAttributes() {
        return this;
    }
}
