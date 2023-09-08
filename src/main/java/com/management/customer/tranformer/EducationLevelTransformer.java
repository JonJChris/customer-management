package com.management.customer.tranformer;

import com.management.customer.model.master.EducationLevelModel;
import com.management.customer.entity.master.EducationLevelType;

public class EducationLevelTransformer {
    public static EducationLevelModel entityToModel(EducationLevelType educationLeveltype){
            return new EducationLevelModel(educationLeveltype.getId(), educationLeveltype.getEducationLevel());
        }

}
