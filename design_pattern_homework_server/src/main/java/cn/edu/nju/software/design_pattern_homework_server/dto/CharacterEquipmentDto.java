package cn.edu.nju.software.design_pattern_homework_server.dto;

import cn.edu.nju.software.design_pattern_homework_server.common.component.AttrComponent;

public class CharacterEquipmentDto extends EquipmentDto implements AttrComponent {
    @Override
    public AttrDto totalAttributes() {
        return null;
    }
}
