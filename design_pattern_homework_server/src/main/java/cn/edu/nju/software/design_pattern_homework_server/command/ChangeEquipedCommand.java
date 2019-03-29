package cn.edu.nju.software.design_pattern_homework_server.command;

import lombok.Data;

@Data
public class ChangeEquipedCommand {
    private Long packId;
    private Long unpackId;
    //private Long userCharacterId;
}
