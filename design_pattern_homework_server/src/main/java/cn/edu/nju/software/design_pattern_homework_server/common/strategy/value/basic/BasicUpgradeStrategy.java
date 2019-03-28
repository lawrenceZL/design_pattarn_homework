package cn.edu.nju.software.design_pattern_homework_server.common.strategy.value.basic;

import cn.edu.nju.software.design_pattern_homework_server.common.strategy.Values;

public interface BasicUpgradeStrategy {

    Values<Double> upgrade(int level, double lastVal, double limit,boolean random);
}
