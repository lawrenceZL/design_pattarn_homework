package cn.edu.nju.software.design_pattern_homework_server.common.strategy.level;

import cn.edu.nju.software.design_pattern_homework_server.common.strategy.Values;

/**
 * 策略模式和模版模式
 */
public interface UpgradeStrategy {

    int cal_needs(int level);

    default boolean isUpperLevel(int level) {
        return false;
    }

    default Values<Integer> upgrade(int level, int current) {
        if (isUpperLevel(level)) {
            return new Values<>(level, current);
        }
        int need = cal_needs(level);
        if (current >= need) {
            current -= need;
            level += 1;
        }
        return new Values<>(level, current);
    }
}
