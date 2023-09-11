package com.management.customer.tranformer;

import com.management.customer.entity.ui.UiFieldRules;
import com.management.customer.model.userInterface.UIFieldModel;

public class UIFieldTransformer {
    public static UIFieldModel entityToModel(UiFieldRules uiFieldRules){
            return new UIFieldModel(
                    uiFieldRules.getId(),
                    uiFieldRules.getUserInterfaceField().getFieldName() ,
                    uiFieldRules.getUserInterfaceField().getFieldDisplayName() ,
                    uiFieldRules.getIsVisible(),
                    uiFieldRules.getIsEditable(),
                    uiFieldRules.getIsMandatory(),
                    uiFieldRules.getUserInterfaceField().getFieldOrder(),
                    uiFieldRules.getUserInterfaceField().getFieldLink());
        }

}
