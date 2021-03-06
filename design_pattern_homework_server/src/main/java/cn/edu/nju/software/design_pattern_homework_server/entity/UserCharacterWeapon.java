package cn.edu.nju.software.design_pattern_homework_server.entity;


import cn.edu.nju.software.design_pattern_homework_server.entity.base.WeaponBaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "t_user_character_weapon")
@EqualsAndHashCode(callSuper = true)
//@org.hibernate.annotations.ForeignKey(name = "none")
public class UserCharacterWeapon extends WeaponBaseEntity {
    @Column(name = "f_user_character_id")
    private Long userCharacterId;

    @Column(name = "f_weapon_id")
    private Long weaponId;

}
