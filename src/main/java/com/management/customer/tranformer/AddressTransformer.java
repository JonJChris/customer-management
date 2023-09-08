package com.management.customer.tranformer;

import com.management.customer.entity.transaction.RequestAddress;
import com.management.customer.model.transaction.AddressModel;

public class AddressTransformer {
    public static AddressModel entityToModel(RequestAddress requestAddress){
        return new AddressModel(
                requestAddress.getAddressId(),
                requestAddress.getRegisteredAddressLine1(),
                requestAddress.getRegisteredAddressLine2(),
                requestAddress.getRegisteredAddressCity(),
                requestAddress.getRegisteredAddressState(),
                CountryTransformer.entityToModel(requestAddress.getRegisteredAddressCountryType()),
                requestAddress.getRegisteredAddressPostalCode(),
                requestAddress.getCommunicationAddressLine1(),
                requestAddress.getCommunicationAddressLine2(),
                requestAddress.getCommunicationAddressCity(),
                requestAddress.getCommunicationAddressState(),
                CountryTransformer.entityToModel(requestAddress.getCommunicationAddressCountryType()),
                requestAddress.getCommunicationAddressPostalCode()
                );
    }



}
