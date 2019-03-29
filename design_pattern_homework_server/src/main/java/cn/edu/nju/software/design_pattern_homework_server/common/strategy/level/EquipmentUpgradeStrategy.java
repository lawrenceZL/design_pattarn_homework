package cn.edu.nju.software.design_pattern_homework_server.common.strategy.level;

import cn.edu.nju.software.design_pattern_homework_server.common.enumeration.EQUIP_TYPE;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EquipmentUpgradeStrategy implements UpgradeStrategy {

    private EQUIP_TYPE type;

    @Override
    public int cal_needs(int level) {
        if (level == 0) {
            return 1;
        }
        if (level == 1) {
            return 2;
        }
        int times = type.ordinal() + 1;
        return level * level * times;
    }

}