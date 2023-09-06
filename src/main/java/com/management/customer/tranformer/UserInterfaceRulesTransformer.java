package com.management.customer.tranformer;

import com.management.customer.dto.UserInterfaceRuleDTO;
import com.management.customer.dto.YearlyIncomeDTO;
import com.management.customer.entity.lookup.UIFieldRules;
import com.management.customer.entity.lookup.YearlyIncome;

public class UserInterfaceRulesTransformer {
    public static  UserInterfaceRuleDTO entityToModel(UIFieldRules uiFieldRules){
            return new UserInterfaceRuleDTO(
                    uiFieldRules.getId(),
                    uiFieldRules.getUiFiled().getFieldName(),
                    uiFieldRules.getRequestType().getRequestType(),
                    uiFieldRules.getRequestStage().getRequestStage(),
                    uiFieldRules.getIsVisible(),
                    uiFieldRules.getIsEditable(),
                    uiFieldRules.getIsMandatory());
        }

}
