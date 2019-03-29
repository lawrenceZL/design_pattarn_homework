package cn.edu.nju.software.design_pattern_homework_server.command;

import cn.edu.nju.software.design_pattern_homework_server.common.enumeration.EQUIP_LEVEL;
import cn.edu.nju.software.design_pattern_homework_server.common.enumeration.EQUIP_TYPE;
import lombok.Data;

@Data
public class EquipCommand {
    private Long id;
    private EQUIP_TYPE type;
    private EQUIP_LEVEL level;
}
