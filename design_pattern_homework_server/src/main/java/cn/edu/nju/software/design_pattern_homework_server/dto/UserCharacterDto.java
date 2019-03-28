package cn.edu.nju.software.design_pattern_homework_server.dto;

import cn.edu.nju.software.design_pattern_homework_server.common.component.AttrComponent;
import lombok.Data;

@Data
public class UserCharacterDto extends CharacterDto implements AttrComponent {

    private Long id;
    private Long userId;
    private Long characterId;
    private String nickname;
    private Integer level;
    private Double currentEXP;
    private Double currentMAG;
    private Double currentHP;

    @Override
    public AttrDto totalAttributes() {
        return this;
    }
}
