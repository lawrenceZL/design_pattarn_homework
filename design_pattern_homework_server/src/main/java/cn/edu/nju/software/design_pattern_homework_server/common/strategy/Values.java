package cn.edu.nju.software.design_pattern_homework_server.common.strategy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Values<T> {
    private T level_or_upper;
    private T current;
}
