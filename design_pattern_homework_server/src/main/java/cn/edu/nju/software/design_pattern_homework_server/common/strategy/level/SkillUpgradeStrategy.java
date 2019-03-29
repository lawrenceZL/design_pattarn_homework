package cn.edu.nju.software.design_pattern_homework_server.common.strategy.level;

import cn.edu.nju.software.design_pattern_homework_server.common.enumeration.SKILL_LEVEL;

public class SkillUpgradeStrategy implements LevelUpgradeStrategy {
    @Override
    public int cal_needs(int level) {
        return 20;
    }

    @Override
    public boolean isUpperLevel(int level) {
        if (level >= SKILL_LEVEL.values().length - 1) {
            return true;
        }
        return false;
    }
}
