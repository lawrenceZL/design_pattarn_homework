package cn.edu.nju.software.design_pattern_homework_server.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@Entity
@Table(name = "t_user_character")
@EqualsAndHashCode(callSuper = true)
@org.hibernate.annotations.ForeignKey(name = "none")
public class UserCharacter extends Character {
    @Column(name = "f_user_id")
    private Long userId;

    @Column(name = "f_character_id")
    private Long characterId;

    @Column(name = "f_user_character_weapon_id")
    private Long userCharacterWeaponId;

    @Column(name = "nickname")
    private String nickname;

}
