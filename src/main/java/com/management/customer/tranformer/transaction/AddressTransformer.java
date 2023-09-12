package com.management.customer.tranformer.transaction;

import com.management.customer.entity.transaction.RequestAddress;
import com.management.customer.model.transaction.request.AddressModel;
import com.management.customer.tranformer.master.CountryTypeTransformer;

public class AddressTransformer {
    public static AddressModel entityToModel(RequestAddress requestAddress){
        return new AddressModel(
                requestAddress.getAddressId(),
                requestAddress.getRegisteredAddressLine1(),
                requestAddress.getRegisteredAddressLine2(),
                requestAddress.getRegisteredAddressCity(),
                requestAddress.getRegisteredAddressState(),
                CountryTypeTransformer.entityToModel(requestAddress.getRegisteredAddressCountryType()),
                requestAddress.getRegisteredAddressPostalCode(),
                requestAddress.getCommunicationAddressLine1(),
                requestAddress.getCommunicationAddressLine2(),
                requestAddress.getCommunicationAddressCity(),
                requestAddress.getCommunicationAddressState(),
                CountryTypeTransformer.entityToModel(requestAddress.getCommunicationAddressCountryType()),
                requestAddress.getCommunicationAddressPostalCode()
                );
    }



}
