package cn.edu.nju.software.design_pattern_homework_server.common.factory;

import cn.edu.nju.software.design_pattern_homework_server.common.factory.product.GoblinCharacter;
import cn.edu.nju.software.design_pattern_homework_server.entity.base.CharacterBaseEntity;

public interface GoblinFactory {
    GoblinCharacter generateGoblin();
}
