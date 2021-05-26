package com.etoak.test.provider;

import com.etoak.test.entity.FundPlan;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "service-provider")
public interface FundPlanServiceProvider {

    @GetMapping("fundPlanProvider/queryProvInfoByCode")
    FundPlan queryProvInfoByCode(@RequestParam("provCode") String provCode);
}
