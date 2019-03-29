package cn.edu.nju.software.design_pattern_homework_server.common.strategy.attack.decorater;


import lombok.Data;


public class EquipDecorator extends DecoratorCommand {

    public EquipDecorator(AttrInterface attr) {
        super(attr);
    }
    @Override
    AttrCommand obtainAttr() {
        return null;
    }
}
