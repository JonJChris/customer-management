package com.management.customer.tranformer.master;

import com.management.customer.model.master.CustomerTypeModel;
import com.management.customer.entity.master.CustomerType;

public class CustomerTypeTransformer {
    public static CustomerTypeModel entityToModel(CustomerType customerType){
            return new CustomerTypeModel(customerType.getId(), customerType.getCustomerType());
        }

}
