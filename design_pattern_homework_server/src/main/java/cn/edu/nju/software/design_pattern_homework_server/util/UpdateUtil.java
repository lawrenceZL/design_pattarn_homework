package cn.edu.nju.software.design_pattern_homework_server.util;

import cn.edu.nju.software.design_pattern_homework_server.common.strategy.value.basic.*;
import cn.edu.nju.software.design_pattern_homework_server.entity.base.AttrBaseEntity;

import java.util.Date;

public class UpdateUtil {

    public synchronized static void upgrade(AttrBaseEntity attrs, int level, boolean random, boolean updateZero) {
        double percent = attrs.getUpgradePercentLimit();
        double value = attrs.getUpgradeValueLimit();
        BasicUpgradeContext basicUpgradeContext;
        if (!(updateZero == false && (null == attrs.getATN() || attrs.getATN() == 0.0))) {
            basicUpgradeContext = new BasicUpgradeContext(new ATNUpgradeStrategy());
            attrs.setATN(basicUpgradeContext.execute(level, attrs.getATN(), value, random).getCurrent());
        }
        if (!(updateZero == false && (null == attrs.getCRIT() || attrs.getCRIT() == 0.0))) {
            basicUpgradeContext = new BasicUpgradeContext(new CRISTUpgradeStrategy());
            attrs.setCRIT(basicUpgradeContext.execute(level, attrs.getCRIT(), percent, random).getCurrent());
        }
        if (!(updateZero == false && (null == attrs.getCRIT_S() || attrs.getCRIT_S() == 0.0))) {
            basicUpgradeContext = new BasicUpgradeContext(new CRISTSUpgradeStrategy());
            attrs.setCRIT_S(basicUpgradeContext.execute(level, attrs.getCRIT_S(), percent, random).getCurrent());
        }
        if (!(updateZero == false && (null == attrs.getDEF() || attrs.getDEF() == 0.0))) {
            basicUpgradeContext = new BasicUpgradeContext(new DEFUpgradeStrategy());
            attrs.setDEF(basicUpgradeContext.execute(level, attrs.getDEF(), value, random).getCurrent());
        }
        if (!(updateZero == false && (null == attrs.getINT() || attrs.getINT() == 0.0))) {
            basicUpgradeContext = new BasicUpgradeContext(new INTUpgradeStrategy());
            attrs.setINT(basicUpgradeContext.execute(level, attrs.getINT(), value, random).getCurrent());
        }
        if (!(updateZero == false && (null == attrs.getRES() || attrs.getRES() == 0.0))) {
            basicUpgradeContext = new BasicUpgradeContext(new RESUpgradeStrategy());
            attrs.setRES(basicUpgradeContext.execute(level, attrs.getRES(), value, random).getCurrent());
        }
        if (!(updateZero == false && (null == attrs.getSPD() || attrs.getSPD() == 0.0))) {
            basicUpgradeContext = new BasicUpgradeContext(new SPDUpgradeStrategy());
            attrs.setSPD(basicUpgradeContext.execute(level, attrs.getSPD(), value, random).getCurrent());
        }
        attrs.setModifyTime(new Date());
        //return attrs;
    }
}
