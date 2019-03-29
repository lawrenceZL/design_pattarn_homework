package cn.edu.nju.software.design_pattern_homework_server.common.strategy.attack;

import cn.edu.nju.software.design_pattern_homework_server.common.enumeration.ATTACK_TYPE;
import cn.edu.nju.software.design_pattern_homework_server.common.strategy.attack.decorater.AttrCommand;

public interface AttackStrategy {
    double attack(AttrCommand attr1, AttrCommand attr2, ATTACK_TYPE type);
}
