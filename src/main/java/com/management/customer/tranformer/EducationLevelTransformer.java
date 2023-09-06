package com.management.customer.tranformer;

import com.management.customer.dto.CustomerTypeDTO;
import com.management.customer.dto.EducationLevelDTO;
import com.management.customer.entity.lookup.CustomerType;
import com.management.customer.entity.lookup.EducationLevel;

public class EducationLevelTransformer {
    public static EducationLevelDTO entityToModel(EducationLevel educationLevel){
            return new EducationLevelDTO(educationLevel.getId(), educationLevel.getEducationLevel());
        }

}
