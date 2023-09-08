package com.management.customer.tranformer;

import com.management.customer.model.master.MaritalStatusModel;
import com.management.customer.entity.master.MaritalStatusType;

public class MaritalStatusTransformer {
    public static MaritalStatusModel entityToModel(MaritalStatusType maritalStatusType){
            return new MaritalStatusModel(maritalStatusType.getId(), maritalStatusType.getMaritalStatus());
        }

}
