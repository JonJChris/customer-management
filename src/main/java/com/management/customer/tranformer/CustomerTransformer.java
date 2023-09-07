package com.management.customer.tranformer;

import com.management.customer.model.transaction.CustomerModel;
import com.management.customer.entity.transaction.Customer;

public class CustomerTransformer {
    public static CustomerModel entityToModel(Customer customer){
        return new CustomerModel(
                customer.getCustomerId(),
                TitleTransformer.entityToModel(customer.getTitle()),
                customer.getFirstname(),
                customer.getLastName(),
                customer.getDisplayName(),
                CountryTransformer.entityToModel(customer.getNationality()),
                customer.getEmail(),
                customer.getDateOfBirth(),
                MaritalStatusTransformer.entityToModel(customer.getMaritalStatus()),
                CustomerTypeTransformer.entityToModel(customer.getCustomerType()),
                EducationLevelTransformer.entityToModel(customer.getEducationLevel()),
                ProfessionTransformer.entityToModel(customer.getProfession()),
                customer.getOrganisationName(),
                YearlyIncomeTransformer.entityToModel(customer.getYearlyIncome()),
                RelationshipTypeTransformer.entityToModel(customer.getNomineeRelationshipType()),
                customer.getNomineeFirstName(),
                customer.getNomineeLastName(),
                customer.getDateOfBirth(),
                HomeOwnershipTypeTransformer.entityToModel(customer.getHomeOwnershipType())

                );
    }



}
