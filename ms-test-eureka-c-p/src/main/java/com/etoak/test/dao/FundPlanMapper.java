package com.etoak.test.dao;

import com.etoak.test.entity.FundPlan;
import org.springframework.stereotype.Repository;

@Repository
public interface FundPlanMapper {
    FundPlan getProvInfoByCode(String provCode);
}
