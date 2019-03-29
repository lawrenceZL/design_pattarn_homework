package cn.edu.nju.software.design_pattern_homework_server.command;

import lombok.Data;

import java.util.List;

@Data
public class PickUpCommand {
    private Long userCharacterId;
    private Integer weaponCoupon;
    private Integer equipmentCoupon;
    private List<EquipCommand> equipments;
}
