package com.management.customer.tranformer;

import com.management.customer.model.master.EducationLevelModel;
import com.management.customer.entity.master.EducationLevel;

public class EducationLevelTransformer {
    public static EducationLevelModel entityToModel(EducationLevel educationLevel){
            return new EducationLevelModel(educationLevel.getId(), educationLevel.getEducationLevel());
        }

}
