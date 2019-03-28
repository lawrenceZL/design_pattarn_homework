package cn.edu.nju.software.design_pattern_homework_server.common.strategy.value;

public interface AttributeUpgradeStrategy {
    double upgrade(int level, double lastVal);
}
