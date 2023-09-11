package com.management.customer.tranformer;

import com.management.customer.entity.store.AddressStore;
import com.management.customer.entity.transaction.RequestAddress;
import com.management.customer.model.transaction.request.AddressModel;
import com.management.customer.model.transaction.store.AddressStoreModel;

public class AddressStoreTransformer {
    public static AddressStoreModel entityToModel(AddressStore addressStore){
        return new AddressStoreModel(
                addressStore.getAddressId(),
                addressStore.getRegisteredAddressLine1(),
                addressStore.getRegisteredAddressLine2(),
                addressStore.getRegisteredAddressCity(),
                addressStore.getRegisteredAddressState(),
                CountryTransformer.entityToModel(addressStore.getRegisteredAddressCountryType()),
                addressStore.getRegisteredAddressPostalCode(),
                addressStore.getCommunicationAddressLine1(),
                addressStore.getCommunicationAddressLine2(),
                addressStore.getCommunicationAddressCity(),
                addressStore.getCommunicationAddressState(),
                CountryTransformer.entityToModel(addressStore.getCommunicationAddressCountryType()),
                addressStore.getCommunicationAddressPostalCode()
                );
    }



}
