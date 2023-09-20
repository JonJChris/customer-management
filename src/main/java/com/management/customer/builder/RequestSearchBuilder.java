package com.management.customer.builder;

import com.management.customer.entity.master.CountryType;
import com.management.customer.entity.master.RequestType;
import com.management.customer.entity.store.CustomerStore;
import com.management.customer.entity.transaction.Request;
import com.management.customer.entity.transaction.RequestCustomer;

public class RequestSearchBuilder {
    private final Request requestEntity;
    public RequestSearchBuilder(){

        requestEntity = new Request();
        requestEntity.setRequestCustomer(new RequestCustomer());
    }

    public RequestSearchBuilder requestId(Long requestId){
        requestEntity.setRequestId(requestId);;
        return this;
    }
    public RequestSearchBuilder customerFirstName(String customerFirstName){
        requestEntity.getRequestCustomer().setFirstname(customerFirstName);;
        return this;
    }
    public RequestSearchBuilder customerLastName(String customerLastName){
        requestEntity.getRequestCustomer().setLastName(customerLastName);;
        return this;
    }
    public RequestSearchBuilder requestType(Integer requestType){
        RequestType lookupRequestType = new RequestType();
        lookupRequestType.setId(requestType);
        requestEntity.setRequestType(lookupRequestType);
        return this;
    }
    public Request build(){
        return this.requestEntity;
    }

}
