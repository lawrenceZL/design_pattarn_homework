package cn.edu.nju.software.design_pattern_homework_server.common.strategy.level;

public class WeaponUpgradeStrategy implements UpgradeStrategy {
    @Override
    public int cal_needs(int level) {
        return level * 5;
    }
}
