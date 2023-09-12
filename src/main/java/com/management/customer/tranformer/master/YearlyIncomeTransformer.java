package com.management.customer.tranformer.master;

import com.management.customer.model.master.YearlyIncomeModel;
import com.management.customer.entity.master.YearlyIncomeType;

public class YearlyIncomeTransformer {
    public static YearlyIncomeModel entityToModel(YearlyIncomeType yearlyIncome){
            return new YearlyIncomeModel(yearlyIncome.getId(), yearlyIncome.getYearlyIncome());
        }

}
