package com.management.customer.tranformer.master;

import com.management.customer.model.master.CustomerStatusModel;
import com.management.customer.entity.master.CustomerStatusType;

public class CustomerStatusTypeTransformer {
    public static CustomerStatusModel entityToModel(CustomerStatusType customerStatusType){
            return new CustomerStatusModel(customerStatusType.getId(), customerStatusType.getCustomerStatus());
        }

}
