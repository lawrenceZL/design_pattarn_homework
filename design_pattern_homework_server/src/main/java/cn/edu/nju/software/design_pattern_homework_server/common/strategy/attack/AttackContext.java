package cn.edu.nju.software.design_pattern_homework_server.common.strategy.attack;

import cn.edu.nju.software.design_pattern_homework_server.common.enumeration.ATTACK_TYPE;

public class AttackContext {
    private AttackStrategy strategy;

    public AttackContext(AttackStrategy strategy) {
        this.strategy = strategy;
    }

    public double execute(AttrCommand attr1, AttrCommand attr2, ATTACK_TYPE type) {
        return strategy.attack(attr1, attr2, type);
    }

}
