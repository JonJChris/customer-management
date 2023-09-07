package com.management.customer.tranformer;

import com.management.customer.model.master.MaritalStatusModel;
import com.management.customer.entity.master.MaritalStatus;

public class MaritalStatusTransformer {
    public static MaritalStatusModel entityToModel(MaritalStatus maritalStatus){
            return new MaritalStatusModel(maritalStatus.getId(), maritalStatus.getMaritalStatus());
        }

}
