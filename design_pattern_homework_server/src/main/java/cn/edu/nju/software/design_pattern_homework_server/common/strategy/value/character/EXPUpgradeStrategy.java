package cn.edu.nju.software.design_pattern_homework_server.common.strategy.value.character;

import cn.edu.nju.software.design_pattern_homework_server.common.strategy.Values;

public class EXPUpgradeStrategy implements CharacterUpgradeStrategy {
    @Override
    public Values<Double> upgrade(int level, double lastVal, double currentVal) {
        if (currentVal>=lastVal){
            currentVal-=lastVal;
        }
        double val = lastVal * 1.5;

        return new Values<>(val, currentVal);
    }
}
