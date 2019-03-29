package cn.edu.nju.software.design_pattern_homework_server.common.strategy.attack.decorater;

import cn.edu.nju.software.design_pattern_homework_server.common.strategy.attack.AttrCommand;

public class AttrUtil {
    public static AttrCommand append(AttrInterface attr1, AttrCommand attr2) {
        return new AttrCommand(attr1.getATN() + attr2.getATN(), attr1.getINT() + attr2.getINT(),
                attr1.getDEF() + attr2.getDEF(), attr1.getRES() + attr2.getRES(), attr1.getCRIT() + attr2.getCRIT(),
                attr1.getCRIT_S() + attr2.getCRIT_S(), attr1.getSPD() + attr2.getSPD());
    }
}
