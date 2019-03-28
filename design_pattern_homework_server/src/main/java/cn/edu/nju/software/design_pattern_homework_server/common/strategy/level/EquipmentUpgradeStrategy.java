package cn.edu.nju.software.design_pattern_homework_server.common.strategy.level;

public class EquipmentUpgradeStrategy implements UpgradeStrategy {
    @Override
    public int cal_needs(int level) {
        if (level == 0) {
            return 1;
        }
        if (level == 1) {
            return 2;
        }
        return level * level;
    }
}