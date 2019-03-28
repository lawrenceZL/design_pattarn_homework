package cn.edu.nju.software.design_pattern_homework_server.common.strategy.value.basic;

import cn.edu.nju.software.design_pattern_homework_server.common.strategy.Values;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BasicUpgradeContext {
    private BasicUpgradeStrategy strategy;

//    public BasicUpgradeContext(BasicUpgradeStrategy strategy) {
//        this.strategy = strategy;
//    }

    public Values<Double> execute(int level, double lastVal, double limit) {
        return strategy.upgrade(level, lastVal, limit);
    }

}
