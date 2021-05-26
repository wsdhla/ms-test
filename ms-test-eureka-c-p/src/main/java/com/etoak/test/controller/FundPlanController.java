package com.etoak.test.controller;

import com.etoak.test.entity.FundPlan;
import com.etoak.test.service.IFundPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequestMapping("/fundPlanProvider")
public class FundPlanController {
    @Autowired
    IFundPlanService fundPlanService;

    @Value("${server.port}")
    String port;

    @Value("${myapp.test.msg}")
    String msg;

    @RequestMapping("/queryProvInfoByCode")
    public FundPlan queryProvInfo(String provCode) {
        /*FundPlan fundPlan = new FundPlan();
        fundPlan.setProvName("测试广东");
        fundPlan.setPort(port);
        return fundPlan;*/

        FundPlan fundPlan = fundPlanService.queryProvInfoByCode(provCode);
        fundPlan.setPort(port);
        fundPlan.setMsg(msg);
        return fundPlan;
    }
}