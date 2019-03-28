package cn.edu.nju.software.design_pattern_homework_server.entity;

import cn.edu.nju.software.design_pattern_homework_server.common.enumeration.EQUIP_LEVEL;
import cn.edu.nju.software.design_pattern_homework_server.common.enumeration.EQUIP_TYPE;
import cn.edu.nju.software.design_pattern_homework_server.entity.base.AttrBaseEntity;
import cn.edu.nju.software.design_pattern_homework_server.entity.base.EquipmentBaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@Entity
@Table(name = "t_euqipment")
@EqualsAndHashCode(callSuper = true)
public class Equipment extends EquipmentBaseEntity {

}
