package com.management.customer.model.store;

import com.management.customer.model.authorisation.UserModel;
import com.management.customer.model.master.*;

import java.time.LocalDate;
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
        LocalDate dateOfBirth,
        MaritalStatusModel maritalStatus,
        CustomerTypeModel customerType,
        EducationLevelModel customerEducationLevel,
        ProfessionModel customerProfession,
        String customerOrganisationName,
        YearlyIncomeModel customerYearlyIncome,
        RelationshipTypeModel nomineeRelationshipType,
        String nomineeFirstName,
        String nomineeLastName,
        LocalDate nomineeDateOfBirth,
        HomeOwnershipTypeModel homeOwnershipType,
        AddressStoreModel addressStoreModel,
        List<ProductStoreModel> productStoreModelList,
        List<DocumentStoreModel> documentStoreModelsList,
        List<RequestStoreModel> requestStoreModelList,
        LocalDateTime createdDate,
        UserModel createdBy,
        LocalDateTime updatedDate,
        UserModel updatedBy
) {
}
