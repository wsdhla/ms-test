package com.etoak.test.service.impl;

import com.etoak.test.dao.FundPlanMapper;
import com.etoak.test.entity.FundPlan;
import com.etoak.test.service.IFundPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FundPlanServiceImpl implements IFundPlanService {
    @Autowired
    FundPlanMapper fundPlanMapper;

    @Override
    public FundPlan queryProvInfoByCode(String provCode) {

        return fundPlanMapper.getProvInfoByCode(provCode);
    }
}
