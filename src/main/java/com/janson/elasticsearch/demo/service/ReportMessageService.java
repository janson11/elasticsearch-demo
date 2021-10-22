package com.janson.elasticsearch.demo.service;

import com.janson.elasticsearch.demo.dto.Result;
import com.janson.elasticsearch.demo.entity.ReportMessage;

/**
 * @Description: ReportMessage Service
 * @Author: shanjian
 * @Date: 2021/10/22 4:43 下午
 */
public interface ReportMessageService {

    /**
     * report message to elasticsearch
     *
     * @param reportMessage reportMessage
     * @return
     */
    Result<String> reportMessage(ReportMessage reportMessage);
}
