package com.janson.elasticsearch.demo;

import com.alibaba.fastjson.JSON;
import com.janson.elasticsearch.demo.entity.ReportMessage;
import com.janson.elasticsearch.demo.utils.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Random;

@SpringBootTest
@Slf4j
@ExtendWith({SpringExtension.class})
class ElasticsearchDemoApplicationTests {

    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    @Value("${spring.application.name:elasticsearch-demo}")
    private String serviceName;

    /**
     * insert report message to elasticsearch
     */
    @Test
    public void insertReportMessage() {
        String currentDate = DateUtils.getDateByString();
        Random random = new Random();
        ReportMessage reportMessage =
                ReportMessage.builder()
                        .id(random.nextLong())
                        .qps(random.toString())
                        .serviceName(serviceName)
                        .threads(random.nextLong())
                        .json(JSON.parseObject("{\"userName\":\"你好\",\"contestId\":10003}"))
                        .build();
        IndexQuery indexQuery = new IndexQueryBuilder().withObject(reportMessage).build();
        String documentId = elasticsearchRestTemplate.index(indexQuery, IndexCoordinates.of(serviceName + "-" + currentDate));
        log.info("documentId:{}", documentId);
    }

}
