package cn.edu.nju.software.design_pattern_homework_server.common.strategy.value;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ValueContext {

    private AttributeUpgradeStrategy strategy;

    public double excute(int level, double lastVal) {
        return strategy.upgrade(level, lastVal);
    }

}
