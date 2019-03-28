package cn.edu.nju.software.design_pattern_homework_server.common.strategy.value.character;

import cn.edu.nju.software.design_pattern_homework_server.common.strategy.Values;

public class HPUpgradeStrategy implements CharacterUpgradeStrategy {

    @Override
    public Values<Double> upgrade(int level, double lastVal, double currentVal) {
        double val = level * 150;
        return new Values<>(val, val);
    }
}
