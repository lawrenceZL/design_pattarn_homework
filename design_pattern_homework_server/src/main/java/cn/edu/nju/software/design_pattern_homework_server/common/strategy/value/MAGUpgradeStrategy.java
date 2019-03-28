package cn.edu.nju.software.design_pattern_homework_server.common.strategy.value;

public class MAGUpgradeStrategy implements AttributeUpgradeStrategy {

    @Override
    public double upgrade(int level, double lastVal) {
        return level * 150;
    }
}
