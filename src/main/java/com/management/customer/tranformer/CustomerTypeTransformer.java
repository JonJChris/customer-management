package com.management.customer.tranformer;

import com.management.customer.dto.CustomerStatusDTO;
import com.management.customer.dto.CustomerTypeDTO;
import com.management.customer.entity.lookup.CustomerStatus;
import com.management.customer.entity.lookup.CustomerType;

public class CustomerTypeTransformer {
    public static  CustomerTypeDTO entityToModel(CustomerType customerType){
            return new CustomerTypeDTO(customerType.getId(), customerType.getCustomerType());
        }

}
