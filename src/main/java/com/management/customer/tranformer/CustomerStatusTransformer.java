package com.management.customer.tranformer;

import com.management.customer.model.master.CustomerStatusModel;
import com.management.customer.entity.master.CustomerStatusType;

public class CustomerStatusTransformer {
    public static CustomerStatusModel entityToModel(CustomerStatusType customerStatusType){
            return new CustomerStatusModel(customerStatusType.getId(), customerStatusType.getCustomerStatus());
        }

}
