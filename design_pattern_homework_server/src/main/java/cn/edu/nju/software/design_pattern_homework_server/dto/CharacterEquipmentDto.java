package cn.edu.nju.software.design_pattern_homework_server.dto;

import cn.edu.nju.software.design_pattern_homework_server.common.component.AttrComponent;
import lombok.Data;

@Data
public class CharacterEquipmentDto extends EquipmentDto implements AttrComponent {
    private Long userCharacterId;

    private Integer upgradeTimes;

    private Boolean equiped;

    @Override
    public AttrDto totalAttributes() {
        return null;
    }
}
