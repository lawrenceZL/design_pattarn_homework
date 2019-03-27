package cn.edu.nju.software.design_pattern_homework_server.command;

import lombok.Data;

@Data
public class BindCharacterCommand {
    private Long userId;
    private Long characterId;
    private String nickname;
}
