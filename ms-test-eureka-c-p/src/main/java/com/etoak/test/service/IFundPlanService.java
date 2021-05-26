package com.etoak.test.service;


import com.etoak.test.entity.FundPlan;

public interface IFundPlanService {
    FundPlan queryProvInfoByCode(String provCode);
}
