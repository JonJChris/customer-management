package com.management.customer.tranformer;

import com.management.customer.dto.TitleDTO;
import com.management.customer.dto.YearlyIncomeDTO;
import com.management.customer.entity.lookup.Title;
import com.management.customer.entity.lookup.YearlyIncome;

public class YearlyIncomeTransformer {
    public static YearlyIncomeDTO entityToModel(YearlyIncome yearlyIncome){
            return new YearlyIncomeDTO(yearlyIncome.getId(), yearlyIncome.getYearlyIncome());
        }

}
