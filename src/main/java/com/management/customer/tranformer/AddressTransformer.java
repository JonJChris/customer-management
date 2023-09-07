package com.management.customer.tranformer;

import com.management.customer.model.transaction.AddressModel;
import com.management.customer.entity.transaction.Address;

public class AddressTransformer {
    public static AddressModel entityToModel(Address address){
        return new AddressModel(
                address.getAddressId(),
                address.getRegisteredAddressLine1(),
                address.getRegisteredAddressLine2(),
                address.getRegisteredAddressCity(),
                address.getRegisteredAddressState(),
                CountryTransformer.entityToModel(address.getRegisteredAddressCountry()),
                address.getRegisteredAddressPostalCode(),
                address.getCommunicationAddressLine1(),
                address.getCommunicationAddressLine2(),
                address.getCommunicationAddressCity(),
                address.getCommunicationAddressState(),
                CountryTransformer.entityToModel(address.getCommunicationAddressCountry()),
                address.getCommunicationAddressPostalCode()
                );
    }



}
