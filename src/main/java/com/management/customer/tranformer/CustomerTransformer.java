package com.management.customer.tranformer;

import com.management.customer.model.transaction.CustomerModel;
import com.management.customer.entity.transaction.RequestCustomer;

public class CustomerTransformer {
    public static CustomerModel entityToModel(RequestCustomer requestCustomer){
        return new CustomerModel(
                requestCustomer.getCustomerId(),
                TitleTransformer.entityToModel(requestCustomer.getTitleType()),
                requestCustomer.getFirstname(),
                requestCustomer.getLastName(),
                requestCustomer.getDisplayName(),
                CountryTransformer.entityToModel(requestCustomer.getNationality()),
                requestCustomer.getEmail(),
                requestCustomer.getDateOfBirth(),
                MaritalStatusTransformer.entityToModel(requestCustomer.getMaritalStatusType()),
                CustomerTypeTransformer.entityToModel(requestCustomer.getCustomerType()),
                EducationLevelTransformer.entityToModel(requestCustomer.getEducationLeveltype()),
                ProfessionTransformer.entityToModel(requestCustomer.getProfessionType()),
                requestCustomer.getOrganisationName(),
                YearlyIncomeTransformer.entityToModel(requestCustomer.getYearlyIncome()),
                RelationshipTypeTransformer.entityToModel(requestCustomer.getNomineeRelationshipType()),
                requestCustomer.getNomineeFirstName(),
                requestCustomer.getNomineeLastName(),
                requestCustomer.getDateOfBirth(),
                HomeOwnershipTypeTransformer.entityToModel(requestCustomer.getHomeOwnershipType())

                );
    }



}
