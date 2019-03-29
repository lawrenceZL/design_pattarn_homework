package cn.edu.nju.software.design_pattern_homework_server.command;

import lombok.Data;

//用于更新数据 以及升级数据
@Data
public class CharacterCommand {
    private Long id;
    private Double EXP;
    private Double HP;
    private Double MAG;
    private Integer level;
    private Double currentEXP;
    private Double currentMAG;
    private Double currentHP;

}
