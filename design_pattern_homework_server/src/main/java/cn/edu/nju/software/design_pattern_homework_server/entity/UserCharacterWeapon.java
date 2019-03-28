package cn.edu.nju.software.design_pattern_homework_server.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "t_user_character_weapon")
@EqualsAndHashCode(callSuper = true)
@org.hibernate.annotations.ForeignKey(name = "none")
public class UserCharacterWeapon extends Weapon implements UpgradeInterface {
    @Column(name = "f_user_character_id")
    private Long userCharacterId;

    @Column(name = "f_upgrade_times")
    private Integer upgradeTimes;

    @Column(name = "f_weapon_id")
    private Long weaponId;

}
