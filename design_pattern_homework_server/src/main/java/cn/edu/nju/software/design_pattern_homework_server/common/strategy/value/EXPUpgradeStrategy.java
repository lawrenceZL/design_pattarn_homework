package cn.edu.nju.software.design_pattern_homework_server.common.strategy.value;

public class EXPUpgradeStrategy implements AttributeUpgradeStrategy {
    @Override
    public double upgrade(int level, double lastVal) {
        return lastVal * 1.5;
    }
}
