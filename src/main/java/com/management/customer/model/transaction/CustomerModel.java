package com.management.customer.model.transaction;

import com.management.customer.model.master.*;

import java.time.LocalDateTime;

public record CustomerModel(
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
        HomeOwnershipTypeModel homeOwnershipType

) {
}
