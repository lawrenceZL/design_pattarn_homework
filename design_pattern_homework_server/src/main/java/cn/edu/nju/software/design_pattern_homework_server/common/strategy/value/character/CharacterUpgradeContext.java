package cn.edu.nju.software.design_pattern_homework_server.common.strategy.value.character;

import cn.edu.nju.software.design_pattern_homework_server.common.strategy.Values;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CharacterUpgradeContext {

    private CharacterUpgradeStrategy strategy;

    public Values<Double> execute(int level, double lastVal, double currentVal) {
        return strategy.upgrade(level, lastVal, currentVal);
    }

}
