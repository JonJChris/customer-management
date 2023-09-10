package com.management.customer.builder;

import com.management.customer.entity.master.CountryType;
import com.management.customer.entity.store.CustomerStore;

public class CustomerStoreBuilder {
    private final CustomerStore customerStore;
    public CustomerStoreBuilder(){
        customerStore = new CustomerStore();
    }

    public CustomerStoreBuilder customerId(Long customerId){
        customerStore.setCustomerId(customerId);;
        return this;
    }
    public CustomerStoreBuilder firstName(String firstName){
        customerStore.setFirstname(firstName);;
        return this;
    }
    public CustomerStoreBuilder lastName(String lastName){
        customerStore.setLastName(lastName);;
        return this;
    }
    public CustomerStoreBuilder nationality(Integer countyId){
        CountryType countryType = new CountryType();
        countryType.setId(countyId);
        customerStore.setNationality(countryType);;
        return this;
    }
    public CustomerStore build(){
        return this.customerStore;
    }

}
