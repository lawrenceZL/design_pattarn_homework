package cn.edu.nju.software.design_pattern_homework_server.util;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomUtil {
    private Random random = new Random();

    public synchronized double randomRange(double lower, double upper) {
        return random.nextDouble() * (upper - lower) + lower;
    }
}
