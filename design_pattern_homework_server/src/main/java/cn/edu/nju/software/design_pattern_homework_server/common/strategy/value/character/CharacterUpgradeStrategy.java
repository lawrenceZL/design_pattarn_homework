package cn.edu.nju.software.design_pattern_homework_server.common.strategy.value.character;

import cn.edu.nju.software.design_pattern_homework_server.common.strategy.Values;

public interface CharacterUpgradeStrategy {
    Values<Double> upgrade(int level, double lastVal, double currentVal);
}
