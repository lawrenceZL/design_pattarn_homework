package cn.edu.nju.software.design_pattern_homework_server.entity;

import cn.edu.nju.software.design_pattern_homework_server.common.enumeration.SEX;
import cn.edu.nju.software.design_pattern_homework_server.entity.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "t_user")
@EqualsAndHashCode(callSuper = true)
public class User extends BaseEntity {
    @Column(name = "f_username")
    private String username;
    @Column(name = "f_password")
    private String password;
    @Column(name = "f_sex")
    private SEX sex;
    @Column(name = "f_mail")
    private String mail;
    @Column(name = "f_tel")
    private String tel;
}
