package com.janson.elasticsearch.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description: Result
 * @Author: shanjian
 * @Date: 2021/10/22 4:53 下午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Result<T> implements Serializable {

    private T data;

    private Integer code;

    private String msg;


    private Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }


    private Result(T data, ResultCodeEnum resultCode) {
        this.code = resultCode.getCode();
        this.msg = resultCode.getMessage();
        this.data = data;
    }

    private Result(ResultCodeEnum resultCode) {
        this.code = resultCode.getCode();
        this.msg = resultCode.getMessage();
    }

    public static <T> Result<T> successResult(T data) {
        return new Result(data, ResultCodeEnum.SUCCESS);
    }


    public static <T> Result<T> failedResult(T data, ResultCodeEnum resultCode) {
        return new Result(data, resultCode);
    }

    public static <T> Result<T> failedResult(T data, Integer code, String msg) {
        Result result = new Result(code, msg);
        result.setData(data);
        return result;
    }

    public static <T> Result<T> failedResult(ResultCodeEnum resultCode) {
        return new Result(resultCode);
    }

    public static <T> Result<T> failedResult(Integer code, String msg) {
        return new Result(code, msg);
    }

    @Override
    public String toString() {
        return "Result(code=" + this.getCode() + ", data=" + this.getData() + ", msg=" + this.getMsg() + ")";
    }
}