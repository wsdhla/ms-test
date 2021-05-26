package com.etoak.test.controller;

import com.etoak.test.entity.FundPlan;
import com.etoak.test.provider.FundPlanServiceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/fundPlan")
public class FundPlanController {
    @Autowired
    FundPlanServiceProvider fundPlanService;

    @RequestMapping("/queryProvInfo/{provCode}")
    public String queryProvInfo(@PathVariable String provCode) {
        FundPlan fundPlan = fundPlanService.queryProvInfoByCode(provCode);
        return fundPlan.getProvName() + " : " + fundPlan.getPort() + " : " + fundPlan.getMsg();
    }
}