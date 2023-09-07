package com.management.customer.tranformer;

import com.management.customer.model.master.YearlyIncomeModel;
import com.management.customer.entity.master.YearlyIncome;

public class YearlyIncomeTransformer {
    public static YearlyIncomeModel entityToModel(YearlyIncome yearlyIncome){
            return new YearlyIncomeModel(yearlyIncome.getId(), yearlyIncome.getYearlyIncome());
        }

}
