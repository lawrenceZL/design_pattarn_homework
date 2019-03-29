package cn.edu.nju.software.design_pattern_homework_server.command;

import cn.edu.nju.software.design_pattern_homework_server.common.enumeration.ATTACK_TYPE;
import cn.edu.nju.software.design_pattern_homework_server.common.factory.product.CommonGoblin;
import cn.edu.nju.software.design_pattern_homework_server.common.factory.product.GoblinCharacter;
import lombok.Data;

@Data
public class AttackCommand {
    private boolean flag;
    private CommonGoblin goblin;
    private Long userCharacterId;
    private Long skillId;
    private ATTACK_TYPE type;
}
