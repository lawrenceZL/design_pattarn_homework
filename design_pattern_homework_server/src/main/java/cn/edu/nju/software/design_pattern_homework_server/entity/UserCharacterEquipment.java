package cn.edu.nju.software.design_pattern_homework_server.entity;

import cn.edu.nju.software.design_pattern_homework_server.entity.base.EquipmentBaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "t_user_character_equipment")
@EqualsAndHashCode(callSuper = true)
//@org.hibernate.annotations.ForeignKey(name = "none")
public class UserCharacterEquipment extends EquipmentBaseEntity {

    @Column(name = "f_user_character_id")
    private Long userCharacterId;

    @Column(name = "f_count")
    private Integer count;

    //是否装备
    @Column(name = "f_equiped")
    private Boolean equiped;

}
