package com.janson.elasticsearch.demo.service.impl;

import com.janson.elasticsearch.demo.dto.Result;
import com.janson.elasticsearch.demo.entity.ReportMessage;
import com.janson.elasticsearch.demo.service.ReportMessageService;
import com.janson.elasticsearch.demo.utils.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.index.IndexResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.stereotype.Service;

/**
 * @Description: ReportMessageService impl
 * @Author: shanjian
 * @Date: 2021/10/22 4:44 下午
 */
@Slf4j
@Service
public class ReportMessageServiceImpl implements ReportMessageService {

    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    @Value("${spring.application.name:elasticsearch-demo}")
    private String serviceName;

    /**
     * report message to elasticsearch
     *
     * @param reportMessage reportMessage
     * @return
     */
    @Override
    public Result<String> reportMessage(ReportMessage reportMessage) {
        String currentDate = DateUtils.getDateByString();
        IndexQuery indexQuery = new IndexQueryBuilder().withObject(reportMessage).build();
        String indexName = serviceName + "-" + currentDate;
        String documentId = null;
        try {
            documentId = elasticsearchRestTemplate.index(indexQuery, IndexCoordinates.of(indexName));
        } catch (Exception e) {
            log.error("report message to elasticsearch error", e);
            return Result.failedResult(504, e.getMessage());
        }
        log.info("indexName:{} documentId:{}", indexName, documentId);
        return Result.successResult(documentId);
    }
}
