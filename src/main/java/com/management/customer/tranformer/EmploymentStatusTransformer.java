package com.management.customer.tranformer;

import com.management.customer.dto.EducationLevelDTO;
import com.management.customer.dto.EmploymentStatusDTO;
import com.management.customer.entity.lookup.EmploymentStatus;

public class EmploymentStatusTransformer {
    public static EmploymentStatusDTO entityToModel(EmploymentStatus employmentStatus){
            return new EmploymentStatusDTO(employmentStatus.getId(), employmentStatus.getEmploymentStatus());
        }

}
