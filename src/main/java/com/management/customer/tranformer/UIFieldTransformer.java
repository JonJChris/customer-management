package com.management.customer.tranformer;

import com.management.customer.model.master.UserInterfaceRuleModel;
import com.management.customer.entity.master.UIFieldRules;
import com.management.customer.model.userInterface.UIFieldModel;

public class UIFieldTransformer {
    public static UIFieldModel entityToModel(UIFieldRules uiFieldRules){
            return new UIFieldModel(
                    uiFieldRules.getId(),
                    uiFieldRules.getUiFiled().getFieldName(),
                    uiFieldRules.getIsVisible(),
                    uiFieldRules.getIsEditable(),
                    uiFieldRules.getIsMandatory());
        }

}
