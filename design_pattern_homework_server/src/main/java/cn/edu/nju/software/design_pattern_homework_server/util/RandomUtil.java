package cn.edu.nju.software.design_pattern_homework_server.util;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
//闭区间
public class RandomUtil {
    private static Random random = new Random();

    public synchronized double randomRange(double lower, double upper) {
        return random.nextDouble() * (upper - lower) + lower;
    }

    public synchronized int randomRange(int lower, int upper) {
        return random.nextInt(upper - lower + 1) + lower;
    }

    public double randomRange(double upper) {
        return this.randomRange(0., upper);
    }

    public int randomRange(int upper) {
        return this.randomRange(0, upper);
    }

    public long random(long lower, long upper) {
        long random_long = lower + (((long) (new Random().nextDouble() * (upper - lower))));
        return random_long;
    }

    public static double random() {
        return random.nextDouble();
    }
}
