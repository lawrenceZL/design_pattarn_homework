package cn.edu.nju.software.design_pattern_homework_server.dto;

import lombok.Data;

import java.util.List;

@Data
public class DroppedDto {

    private List<EquipmentDto> equipments;

    private Integer weaponCoupon;

    private Integer equipmentCoupon;
}
