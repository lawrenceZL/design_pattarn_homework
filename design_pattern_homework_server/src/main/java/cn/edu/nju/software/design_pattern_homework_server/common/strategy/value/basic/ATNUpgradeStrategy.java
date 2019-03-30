package cn.edu.nju.software.design_pattern_homework_server.common.strategy.value.basic;

import cn.edu.nju.software.design_pattern_homework_server.common.strategy.Values;
import cn.edu.nju.software.design_pattern_homework_server.util.RandomUtil;

import javax.annotation.Resource;

public class ATNUpgradeStrategy implements BasicUpgradeStrategy {
    @Override
    public Values<Double> upgrade(int level, double lastVal, double limit, boolean random) {
        if (random) {
            double current = RandomUtil.randomRange(lastVal, lastVal + limit);
            return new Values<>(limit, current);
        } else {
            return new Values<>(limit, lastVal + limit);
        }
    }
}
