package com.management.customer.tranformer;

import com.management.customer.dto.CustomerStatusDTO;
import com.management.customer.dto.RequestTypeDTO;
import com.management.customer.entity.lookup.CustomerStatus;
import com.management.customer.entity.lookup.RequestType;

public class CustomerStatusTransformer {
    public static CustomerStatusDTO entityToModel(CustomerStatus customerStatus){
            return new CustomerStatusDTO(customerStatus.getId(), customerStatus.getCustomerStatus());
        }

}
