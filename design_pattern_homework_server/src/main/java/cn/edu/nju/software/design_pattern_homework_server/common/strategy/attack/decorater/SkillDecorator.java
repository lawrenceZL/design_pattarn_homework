package cn.edu.nju.software.design_pattern_homework_server.common.strategy.attack.decorater;

import cn.edu.nju.software.design_pattern_homework_server.common.strategy.attack.AttrCommand;

public class SkillDecorator extends DecoratorCommand{

    public SkillDecorator(AttrInterface attr) {
        super(attr);
    }
    @Override
    public AttrCommand obtainAttr() {
        return AttrUtil.append(this, attr.obtainAttr());
    }
}
