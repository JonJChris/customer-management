package com.management.customer.builder;

import com.management.customer.entity.master.CountryType;
import com.management.customer.entity.store.CustomerStore;

public class CustomerSearchBuilder {
    private final CustomerStore customerStore;
    public CustomerSearchBuilder(){
        customerStore = new CustomerStore();
    }

    public CustomerSearchBuilder customerId(Long customerId){
        customerStore.setCustomerId(customerId);;
        return this;
    }
    public CustomerSearchBuilder firstName(String firstName){
        customerStore.setFirstname(firstName);;
        return this;
    }
    public CustomerSearchBuilder lastName(String lastName){
        customerStore.setLastName(lastName);;
        return this;
    }
    public CustomerSearchBuilder nationality(Integer countyId){
        CountryType countryType = new CountryType();
        countryType.setId(countyId);
        customerStore.setNationality(countryType);;
        return this;
    }
    public CustomerStore build(){
        return this.customerStore;
    }

}
