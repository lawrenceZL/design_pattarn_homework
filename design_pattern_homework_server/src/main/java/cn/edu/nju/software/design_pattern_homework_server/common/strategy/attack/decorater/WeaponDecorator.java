package cn.edu.nju.software.design_pattern_homework_server.common.strategy.attack.decorater;

public class WeaponDecorator extends DecoratorCommand{

    public WeaponDecorator(AttrInterface attr) {
        super(attr);
    }
    @Override
    AttrCommand obtainAttr() {
        return null;
    }
}
