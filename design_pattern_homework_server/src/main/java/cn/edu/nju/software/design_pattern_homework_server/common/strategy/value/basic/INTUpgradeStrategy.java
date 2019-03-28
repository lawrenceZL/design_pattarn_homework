package cn.edu.nju.software.design_pattern_homework_server.common.strategy.value.basic;

import cn.edu.nju.software.design_pattern_homework_server.common.strategy.Values;
import cn.edu.nju.software.design_pattern_homework_server.common.strategy.value.character.CharacterUpgradeStrategy;

public class INTUpgradeStrategy implements CharacterUpgradeStrategy {
    @Override
    public Values<Double> upgrade(int level, double lastVal, double currentVal) {
        return null;
    }
}

