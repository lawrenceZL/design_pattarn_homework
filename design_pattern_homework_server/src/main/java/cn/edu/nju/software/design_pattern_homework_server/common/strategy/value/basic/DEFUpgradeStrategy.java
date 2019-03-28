package cn.edu.nju.software.design_pattern_homework_server.common.strategy.value.basic;

import cn.edu.nju.software.design_pattern_homework_server.common.strategy.Values;

public class DEFUpgradeStrategy implements BasicUpgradeStrategy {
    @Override
    public Values<Double> upgrade(int level, double lastVal, double limit) {
        return null;
    }
}
