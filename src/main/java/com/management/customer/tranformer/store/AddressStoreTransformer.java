package com.management.customer.tranformer.store;

import com.management.customer.entity.store.AddressStore;
import com.management.customer.model.store.AddressStoreModel;
import com.management.customer.tranformer.master.CountryTypeTransformer;

public class AddressStoreTransformer {
    public static AddressStoreModel entityToModel(AddressStore addressStore){
        return new AddressStoreModel(
                addressStore.getAddressId(),
                addressStore.getRegisteredAddressLine1(),
                addressStore.getRegisteredAddressLine2(),
                addressStore.getRegisteredAddressCity(),
                addressStore.getRegisteredAddressState(),
                addressStore.getRegisteredAddressCountryType() != null ? CountryTypeTransformer.entityToModel(addressStore.getRegisteredAddressCountryType()) :null,
                addressStore.getRegisteredAddressPostalCode(),
                addressStore.getCommunicationAddressLine1(),
                addressStore.getCommunicationAddressLine2(),
                addressStore.getCommunicationAddressCity(),
                addressStore.getCommunicationAddressState(),
                addressStore.getCommunicationAddressCountryType() != null ? CountryTypeTransformer.entityToModel(addressStore.getCommunicationAddressCountryType()) : null,
                addressStore.getCommunicationAddressPostalCode()
                );
    }



}
