package com.janson.elasticsearch.demo.entity;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Map;

/**
 * @Description: report message
 * @Author: shanjian
 * @Date: 2021/10/20 7:24 下午
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Builder()
public class ReportMessage {

    @Id
    private Long id;

    @Field(type = FieldType.Keyword)
    private String qps;

    @Field(type = FieldType.Long)
    private Long threads;

    @Field(type = FieldType.Text)
    private String serviceName;

    @Field(type = FieldType.Auto)
    private JSONObject json;
}