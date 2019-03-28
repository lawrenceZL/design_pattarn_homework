package cn.edu.nju.software.design_pattern_homework_server.common.strategy.value.basic;

import cn.edu.nju.software.design_pattern_homework_server.common.strategy.Values;
import cn.edu.nju.software.design_pattern_homework_server.util.RandomUtil;

import javax.annotation.Resource;

public class CRISTUpgradeStrategy implements BasicUpgradeStrategy {
    @Resource
    private RandomUtil randomUtil;

    @Override
    public Values<Double> upgrade(int level, double lastVal, double limit, boolean random) {
        if (random) {
            double current = randomUtil.randomRange(lastVal, lastVal + limit);
            if (current >= 100.) {
                current = 100.0;
            }
            return new Values<>(limit, current);
        } else {
            return new Values<>(limit, lastVal + limit);
        }
    }
}
