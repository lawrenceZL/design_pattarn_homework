package cn.edu.nju.software.design_pattern_homework_server.entity.base;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@MappedSuperclass
public class BaseEntity {
    @Id
    @Column(name = "f_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "f_create_time")
    private Date createTime;

    @Column(name = "f_modify_time")
    private Date modifyTime;

    public BaseEntity() {
        modifyTime = new Date();
    }
}
