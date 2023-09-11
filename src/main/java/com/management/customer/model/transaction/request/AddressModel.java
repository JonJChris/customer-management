package com.management.customer.model.transaction.request;

import com.management.customer.model.master.CountryModel;

public record AddressModel(
        Long addressId,
        String registeredAddressLine1,
        String registeredAddressLine2,
        String registeredAddressCity,
        String registeredAddressState,
        CountryModel registeredAddressCountry,
        String  registeredAddressPostalCode,
        String communicationAddressLine1,
        String communicationAddressLine2,
        String communicationAddressCity,
        String communicationAddressState,
        CountryModel communicationAddressCountry,
        String  communicationAddressPostalCode
) {
}
