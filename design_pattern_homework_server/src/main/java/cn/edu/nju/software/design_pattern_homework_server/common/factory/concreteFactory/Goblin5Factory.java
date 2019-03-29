package cn.edu.nju.software.design_pattern_homework_server.common.factory.concreteFactory;

import cn.edu.nju.software.design_pattern_homework_server.common.factory.GoblinFactory;
import cn.edu.nju.software.design_pattern_homework_server.common.factory.product.Goblin4;
import cn.edu.nju.software.design_pattern_homework_server.common.factory.product.Goblin5;
import cn.edu.nju.software.design_pattern_homework_server.common.factory.product.GoblinCharacter;
import cn.edu.nju.software.design_pattern_homework_server.entity.base.CharacterBaseEntity;

public class Goblin5Factory implements GoblinFactory {
    @Override
    public GoblinCharacter generateGoblin(CharacterBaseEntity attrs) {
        Goblin5 goblin = new Goblin5();
        goblin.init(attrs);
        return goblin;
    }
}
