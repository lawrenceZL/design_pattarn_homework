package cn.edu.nju.software.design_pattern_homework_server.common.result;

import lombok.Data;

@Data
public class Result {

    private String code;
    private String message;
    private boolean success;
    private Object data;

    public static Result success() {
        Result result = new Result();
        result.success = true;
        //默认200，可通过code方法进行修改
        result.setCode("200");
        return result;
    }

    public static Result error() {
        Result result = new Result();
        result.success = false;
        //默认500 可以通过code方法进行修改
        result.setCode("500");
        return result;
    }

    public Result withData(Object data) {
        this.setData(data);
        return this;
    }

    public Result code(String code) {
        this.setCode(code);
        return this;
    }

    public Result code(int code) {
        this.setCode(code + "");
        return this;
    }

    public Result message(String message) {
        this.setMessage(message);
        return this;
    }
}
