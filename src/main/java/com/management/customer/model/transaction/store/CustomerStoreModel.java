package com.management.customer.model.transaction.store;

import com.management.customer.model.authorisation.UserModel;
import com.management.customer.model.master.*;

import java.time.LocalDateTime;
import java.util.List;

public record CustomerStoreModel(
        Long customerId,
        TitleModel userTitle,
        String firstName,
        String lastName,
        String displayName,
        CountryModel nationality,
        String email,
        LocalDateTime dateOfBirth,
        MaritalStatusModel maritalStatus,
        CustomerTypeModel customerType,
        EducationLevelModel customerEducationLevel,
        ProfessionModel customerProfession,
        String customerOrganisationName,
        YearlyIncomeModel customerYearlyIncome,
        RelationshipTypeModel nomineeRelationshipType,
        String nomineeFirstName,
        String nomineeLastName,
        LocalDateTime nomineeDateOfBirth,
        HomeOwnershipTypeModel homeOwnershipType,
        LocalDateTime createdDate,
        UserModel createdBy,
        LocalDateTime updatedDate,
        UserModel updatedBy,
        AddressStoreModel addressStoreModel,
        List<RequestStoreModel> requestStoreModelList

) {
}