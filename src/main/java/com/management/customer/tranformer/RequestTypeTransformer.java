package com.management.customer.tranformer;

import com.management.customer.dto.RequestTypeDTO;
import com.management.customer.entity.lookup.RequestType;

public class RequestTypeTransformer {
        public static RequestTypeDTO entityToModel(RequestType requestType){
            return new RequestTypeDTO(requestType.getId(), requestType.getRequestType());
        }

}
