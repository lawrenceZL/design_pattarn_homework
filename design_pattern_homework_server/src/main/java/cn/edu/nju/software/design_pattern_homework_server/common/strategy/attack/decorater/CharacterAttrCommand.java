package cn.edu.nju.software.design_pattern_homework_server.common.strategy.attack.decorater;


import cn.edu.nju.software.design_pattern_homework_server.common.strategy.attack.AttrCommand;

public class CharacterAttrCommand extends AttrInterface {
    @Override
    public AttrCommand obtainAttr() {
        return new AttrCommand(this.getATN(), this.getINT(), this.getDEF(), this.getRES(), this.getCRIT(), this.getCRIT_S(), this.getSPD());
    }
}
