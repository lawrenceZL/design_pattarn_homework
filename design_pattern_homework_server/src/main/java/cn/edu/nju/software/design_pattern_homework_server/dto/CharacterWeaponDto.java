package cn.edu.nju.software.design_pattern_homework_server.dto;

import lombok.Data;

@Data
public class CharacterWeaponDto extends AttrDto {
    public Long getUserCharacterId() {
        return userCharacterId;
    }

    public void setUserCharacterId(Long userCharacterId) {
        this.userCharacterId = userCharacterId;
    }

    // 内部变量
    private Long userCharacterId;

    //外部变量
    private Long userCharacterEquipmentId;

    public CharacterWeaponDto(Long userCharacterEquipmentId) {
        this.userCharacterEquipmentId = userCharacterEquipmentId;
    }

}
