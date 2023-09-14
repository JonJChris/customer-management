package com.management.customer.model.transaction.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.management.customer.model.master.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record CustomerModel(
        Long customerId,
        TitleModel userTitle,
        String firstName,
        String lastName,
        String displayName,
        CountryModel nationality,
        String email,
        @JsonFormat(pattern = "yyyy-MM-dd")
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
        @JsonFormat(pattern = "yyyy-MM-dd")
        LocalDate nomineeDateOfBirth,
        HomeOwnershipTypeModel homeOwnershipType

) {
}
