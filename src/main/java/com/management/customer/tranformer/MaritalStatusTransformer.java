package com.management.customer.tranformer;

import com.management.customer.dto.EducationLevelDTO;
import com.management.customer.dto.MaritalStatusDTO;
import com.management.customer.entity.lookup.EducationLevel;
import com.management.customer.entity.lookup.MaritalStatus;

public class MaritalStatusTransformer {
    public static MaritalStatusDTO entityToModel(MaritalStatus maritalStatus){
            return new MaritalStatusDTO(maritalStatus.getId(), maritalStatus.getMaritalStatus());
        }

}
