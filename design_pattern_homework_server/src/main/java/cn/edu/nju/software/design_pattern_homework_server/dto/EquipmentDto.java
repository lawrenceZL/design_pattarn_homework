package cn.edu.nju.software.design_pattern_homework_server.dto;

import cn.edu.nju.software.design_pattern_homework_server.common.enumeration.EQUIP_LEVEL;
import cn.edu.nju.software.design_pattern_homework_server.common.enumeration.EQUIP_TYPE;
import lombok.Data;

@Data
public class EquipmentDto extends AttrDto {

    private EQUIP_TYPE type;
    private EQUIP_LEVEL level;
    private String name;
    private Double upgradeValueLimit;
    private Double upgradePercentLimit;
    private Long characterId;
}
