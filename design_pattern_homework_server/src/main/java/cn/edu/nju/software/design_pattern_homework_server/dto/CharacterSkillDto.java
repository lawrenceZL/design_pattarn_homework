package cn.edu.nju.software.design_pattern_homework_server.dto;

import cn.edu.nju.software.design_pattern_homework_server.common.component.AttrComponent;
import lombok.Data;

@Data
public class CharacterSkillDto extends SkillDto implements AttrComponent {

    private Long userCharacterId;

    private Integer upgradeTimes;

    @Override
    public AttrDto totalAttributes() {
        return null;
    }
}
