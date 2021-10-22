package com.janson.elasticsearch.demo.controller;

import com.janson.elasticsearch.demo.dto.Result;
import com.janson.elasticsearch.demo.entity.ReportMessage;
import com.janson.elasticsearch.demo.service.ReportMessageService;
import org.elasticsearch.action.index.IndexResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: ReportMessage Controller
 * @Author: shanjian
 * @Date: 2021/10/22 4:42 下午
 */
@RestController
@RequestMapping("/report")
public class ReportMessageController {

    @Autowired
    private ReportMessageService reportMessageService;


    @RequestMapping("/message")
    public Result<String> reportMessage(@RequestBody ReportMessage reportMessage) {
        return reportMessageService.reportMessage(reportMessage);
    }


}
