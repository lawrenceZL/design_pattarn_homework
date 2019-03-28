package cn.edu.nju.software.design_pattern_homework_server.dto;

import cn.edu.nju.software.design_pattern_homework_server.common.enumeration.EQUIP_TYPE;
import com.google.common.collect.Maps;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;


public class UserCharacterDetailDto extends UserCharacterDto {
    private Map<EQUIP_TYPE, CharacterEquipmentDto> equipmentMap = Maps.newConcurrentMap();

    @Getter
    @Setter
    private CharacterWeaponDto weapon;
    @Getter
    @Setter
    private List<CharacterSkillDto> skills;

    public void pushEquipment(CharacterEquipmentDto dto) {
        equipmentMap.put(dto.getType(), dto);
    }

    public CharacterEquipmentDto getEquipment(EQUIP_TYPE type) {
        return equipmentMap.get(type);
    }

}
