package cn.edu.nju.software.design_pattern_homework_server.common.factory;

import cn.edu.nju.software.design_pattern_homework_server.common.factory.concreteFactory.*;
import cn.edu.nju.software.design_pattern_homework_server.common.factory.product.GoblinCharacter;
import cn.edu.nju.software.design_pattern_homework_server.entity.base.CharacterBaseEntity;
import cn.edu.nju.software.design_pattern_homework_server.util.RandomUtil;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class GoblinContext {
    @Resource
    private RandomUtil randomUtil;

    private static final int MAX_SIZE_PER_TYPE = 3;

    public List<GoblinCharacter> generate(CharacterBaseEntity attrs) {
        List<GoblinCharacter> characters = Lists.newArrayList();
        //GoblinFactory factory1 = new Goblin1Factory();
        //GoblinFactory factory2 = new Goblin2Factory();
        //GoblinFactory factory3 = new Goblin3Factory();
        //GoblinFactory factory4 = new Goblin4Factory();
        //GoblinFactory factory5 = new Goblin5Factory();
        List<GoblinFactory> factories = Lists.newArrayList();
        factories.add(new Goblin1Factory());
        factories.add(new Goblin2Factory());
        factories.add(new Goblin3Factory());
        factories.add(new Goblin4Factory());
        factories.add(new Goblin5Factory());
        for (GoblinFactory factory : factories) {
            int size = randomUtil.randomRange(0, MAX_SIZE_PER_TYPE);
            for (int i = 0; i < size; i++) {
                characters.add(factory.generateGoblin(attrs));
            }
        }
        return characters;
    }
}
