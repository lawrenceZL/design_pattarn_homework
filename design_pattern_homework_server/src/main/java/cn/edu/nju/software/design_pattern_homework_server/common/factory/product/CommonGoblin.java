package cn.edu.nju.software.design_pattern_homework_server.common.factory.product;

import cn.edu.nju.software.design_pattern_homework_server.common.enumeration.GOBLIN_TYPE;
import cn.edu.nju.software.design_pattern_homework_server.entity.base.CharacterBaseEntity;
import lombok.Data;

@Data
public class CommonGoblin extends CharacterBaseEntity {
    private GOBLIN_TYPE type;
}
