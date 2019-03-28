package cn.edu.nju.software.design_pattern_homework_server.common.factory;

import cn.edu.nju.software.design_pattern_homework_server.common.enumeration.GOBLIN_TYPE;
import cn.edu.nju.software.design_pattern_homework_server.entity.base.CharacterBaseEntity;

public abstract class GoblinCharacter extends CharacterBaseEntity {
    private GOBLIN_TYPE type;
}
