package cn.edu.nju.software.design_pattern_homework_server.command;

import lombok.Data;

@Data
public class UpgradeCommand {
    private Long id;
    private Long userCharacterId;
    private Integer currentLevel;
}
