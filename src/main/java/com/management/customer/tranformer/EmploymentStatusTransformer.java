package com.management.customer.tranformer;

import com.management.customer.model.master.EmploymentStatusModel;
import com.management.customer.entity.master.EmploymentStatusType;

public class EmploymentStatusTransformer {
    public static EmploymentStatusModel entityToModel(EmploymentStatusType employmentStatustype){
            return new EmploymentStatusModel(employmentStatustype.getId(), employmentStatustype.getEmploymentStatus());
        }

}
