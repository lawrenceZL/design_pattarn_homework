package cn.edu.nju.software.design_pattern_homework_server.common.strategy.level;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class LevelContext {
    private UpgradeStrategy strategy;

    public int excute(int level) {
        return strategy.cal_needs(level);
    }

}
