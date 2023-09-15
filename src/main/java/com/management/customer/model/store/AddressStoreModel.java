package com.management.customer.model.store;

import com.management.customer.model.authorisation.UserModel;
import com.management.customer.model.master.CountryModel;

import java.time.LocalDateTime;

public record AddressStoreModel(
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
        String  communicationAddressPostalCode,
        LocalDateTime createdDate,
        UserModel createdBy,
        LocalDateTime updatedDate,
        UserModel updatedBy
) {
}
