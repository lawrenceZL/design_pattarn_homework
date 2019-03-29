package cn.edu.nju.software.design_pattern_homework_server.common.strategy.attack.decorater;

//Decorator
public abstract class DecoratorCommand extends AttrInterface {
    protected AttrInterface attr;

    public DecoratorCommand(AttrInterface attr) {
        this.attr = attr;
    }
}
