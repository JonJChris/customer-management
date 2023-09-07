package com.management.customer.tranformer;

import com.management.customer.model.master.CustomerStatusModel;
import com.management.customer.entity.master.CustomerStatus;

public class CustomerStatusTransformer {
    public static CustomerStatusModel entityToModel(CustomerStatus customerStatus){
            return new CustomerStatusModel(customerStatus.getId(), customerStatus.getCustomerStatus());
        }

}
