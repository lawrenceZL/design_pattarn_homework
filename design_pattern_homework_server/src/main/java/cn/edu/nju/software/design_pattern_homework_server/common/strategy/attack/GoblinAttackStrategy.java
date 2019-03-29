package cn.edu.nju.software.design_pattern_homework_server.common.strategy.attack;

import cn.edu.nju.software.design_pattern_homework_server.common.enumeration.ATTACK_TYPE;
import cn.edu.nju.software.design_pattern_homework_server.util.RandomUtil;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

public class GoblinAttackStrategy implements AttackStrategy {

    @Override
    public double hit(AttrCommand attr1, AttrCommand attr2, ATTACK_TYPE type) {
        //魔法还是物理伤害
        double attack_value = (type == ATTACK_TYPE.ATN) ? attr1.getATN() : attr1.getINT();
        //是否产生暴击
        boolean crist = (RandomUtil.random() < (attr1.getCRIT() / 100));
        attack_value = attack_value * (crist ? (1 + attr1.getCRIT_S() / 100) : 1);

        double def1 = (type == ATTACK_TYPE.ATN) ? attr1.getDEF() : attr1.getRES();
        double def2 = (type == ATTACK_TYPE.ATN) ? attr2.getDEF() : attr2.getRES();
        if ((int) def2 == 0) {
            return attack_value;
        }
        if ((int) def1 == 0) {
            return attack_value / 10;
        }
        attack_value *= (def1 / (def1 + def2));
        return attack_value;
    }

    @Override
    public boolean isProtected(AttrCommand attr1, AttrCommand attr2) {
        double probability = attr2.getSPD() / (attr2.getSPD() + attr1.getSPD());
        if (RandomUtil.random() < probability) {
            return true;
        }
        return false;
    }
}
