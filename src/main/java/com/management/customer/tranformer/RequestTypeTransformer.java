package com.management.customer.tranformer;

import com.management.customer.model.master.RequestTypeModel;
import com.management.customer.entity.master.RequestType;

public class RequestTypeTransformer {
        public static RequestTypeModel entityToModel(RequestType requestType){
            return new RequestTypeModel(requestType.getId(), requestType.getRequestType());
        }

}
