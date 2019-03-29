package cn.edu.nju.software.design_pattern_homework_server.common.factory.concreteFactory;

import cn.edu.nju.software.design_pattern_homework_server.common.factory.GoblinFactory;
import cn.edu.nju.software.design_pattern_homework_server.common.factory.product.Goblin3;
import cn.edu.nju.software.design_pattern_homework_server.common.factory.product.GoblinCharacter;

public class Goblin3Factory implements GoblinFactory {
    @Override
    public GoblinCharacter generateGoblin() {
        return new Goblin3();
    }
}
