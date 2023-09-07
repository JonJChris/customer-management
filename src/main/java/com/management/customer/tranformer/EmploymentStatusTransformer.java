package com.management.customer.tranformer;

import com.management.customer.model.master.EmploymentStatusModel;
import com.management.customer.entity.master.EmploymentStatus;

public class EmploymentStatusTransformer {
    public static EmploymentStatusModel entityToModel(EmploymentStatus employmentStatus){
            return new EmploymentStatusModel(employmentStatus.getId(), employmentStatus.getEmploymentStatus());
        }

}
