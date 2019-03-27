package cn.edu.nju.software.design_pattern_homework_server.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "t_user_character_equipment")
@EqualsAndHashCode(callSuper = true)
public class UserCharacterEquipment extends Equipment implements UpgradeInterface {

    @Column(name = "f_user_character_id")
    private Long userCharacterId;

    @Column(name = "f_upgrade_times")
    private Integer upgradeTimes;

    @Column(name = "f_count")
    private Integer count;

}
