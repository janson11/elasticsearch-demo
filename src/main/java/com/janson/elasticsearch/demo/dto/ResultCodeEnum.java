package com.janson.elasticsearch.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Description: ResultCodeEnum
 * @Author: shanjian
 * @Date: 2021/10/22 4:54 下午
 */
@Getter
@AllArgsConstructor
public enum ResultCodeEnum {

    SUCCESS(200, "操作成功"),
    FAIL(500, "操作失败");

    /**
     * 编码
     */
    Integer code;
    /**
     * 描述
     */
    String message;
}
