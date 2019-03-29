package cn.edu.nju.software.design_pattern_homework_server.common.factory.concreteFactory;

import cn.edu.nju.software.design_pattern_homework_server.common.factory.GoblinFactory;
import cn.edu.nju.software.design_pattern_homework_server.common.factory.product.Goblin4;
import cn.edu.nju.software.design_pattern_homework_server.common.factory.product.Goblin5;
import cn.edu.nju.software.design_pattern_homework_server.common.factory.product.GoblinCharacter;
import cn.edu.nju.software.design_pattern_homework_server.entity.base.CharacterBaseEntity;

public class Goblin4Factory implements GoblinFactory {

    @Override
    public GoblinCharacter generateGoblin(CharacterBaseEntity attrs) {
        Goblin4 goblin = new Goblin4();
        goblin.init(attrs);
        return goblin;
    }
}
