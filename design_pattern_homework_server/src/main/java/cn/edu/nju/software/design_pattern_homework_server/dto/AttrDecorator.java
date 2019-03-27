package cn.edu.nju.software.design_pattern_homework_server.dto;

import cn.edu.nju.software.design_pattern_homework_server.common.component.AttrComponent;
import lombok.AllArgsConstructor;

//Decorator
@AllArgsConstructor
public abstract class AttrDecorator implements AttrComponent {
    private AttrComponent attrComponent;
}
