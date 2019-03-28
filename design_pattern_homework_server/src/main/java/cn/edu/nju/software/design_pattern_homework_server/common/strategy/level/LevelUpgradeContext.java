package cn.edu.nju.software.design_pattern_homework_server.common.strategy.level;

import cn.edu.nju.software.design_pattern_homework_server.common.strategy.Values;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class LevelUpgradeContext {
    private UpgradeStrategy strategy;

    public Values<Integer> execute(int level, int current) {
        return strategy.upgrade(level, current);
    }

}
