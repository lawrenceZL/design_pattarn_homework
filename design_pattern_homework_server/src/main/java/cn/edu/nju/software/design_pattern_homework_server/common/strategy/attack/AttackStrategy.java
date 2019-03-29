package cn.edu.nju.software.design_pattern_homework_server.common.strategy.attack;

import cn.edu.nju.software.design_pattern_homework_server.common.enumeration.ATTACK_TYPE;

public interface AttackStrategy {

    double hit(AttrCommand attr1, AttrCommand attr2, ATTACK_TYPE type);

    //是否闪避成功
    boolean isProtected(AttrCommand attr1, AttrCommand attr2);

    default double attack(AttrCommand attr1, AttrCommand attr2, ATTACK_TYPE type) {
        if (isProtected(attr1, attr2)) {
            return 0.0;
        } else {
            return hit(attr1, attr2, type);
        }
    }
}
