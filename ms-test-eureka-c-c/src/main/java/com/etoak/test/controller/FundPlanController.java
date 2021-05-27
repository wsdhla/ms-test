package com.etoak.test.controller;

import com.etoak.test.entity.FundPlan;
import com.etoak.test.provider.FundPlanServiceProvider;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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

    @HystrixCommand(fallbackMethod = "queryProvInfoError",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })
    @RequestMapping("/queryProvInfo/{provCode}")
    public String queryProvInfo(@PathVariable String provCode) {
        FundPlan fundPlan = fundPlanService.queryProvInfoByCode(provCode);
        return fundPlan.getProvName() + " : " + fundPlan.getPort() + " : " + fundPlan.getMsg();
    }


    public String queryProvInfoError(@PathVariable String provCode) {
        return "当前网络链接有问题，请稍后再试";
    }

}