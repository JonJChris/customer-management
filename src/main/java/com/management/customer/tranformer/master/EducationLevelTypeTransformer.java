package com.management.customer.tranformer.master;

import com.management.customer.model.master.EducationLevelModel;
import com.management.customer.entity.master.EducationLevelType;

public class EducationLevelTypeTransformer {
    public static EducationLevelModel entityToModel(EducationLevelType educationLeveltype){
            return new EducationLevelModel(educationLeveltype.getId(), educationLeveltype.getEducationLevel());
        }

}
