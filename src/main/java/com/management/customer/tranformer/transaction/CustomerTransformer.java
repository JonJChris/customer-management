package com.management.customer.tranformer.transaction;

import com.management.customer.model.transaction.request.CustomerModel;
import com.management.customer.entity.transaction.RequestCustomer;
import com.management.customer.tranformer.master.*;

public class CustomerTransformer {
    public static CustomerModel entityToModel(RequestCustomer requestCustomer){
        return new CustomerModel(
                requestCustomer.getCustomerId(),
                TitleTypeTransformer.entityToModel(requestCustomer.getTitleType()),
                requestCustomer.getFirstname(),
                requestCustomer.getLastName(),
                requestCustomer.getDisplayName(),
                CountryTypeTransformer.entityToModel(requestCustomer.getNationality()),
                requestCustomer.getEmail(),
                requestCustomer.getDateOfBirth(),
                MaritalStatusTypeTransformer.entityToModel(requestCustomer.getMaritalStatusType()),
                CustomerTypeTransformer.entityToModel(requestCustomer.getCustomerType()),
                EducationLevelTypeTransformer.entityToModel(requestCustomer.getEducationLeveltype()),
                ProfessionTypeTransformer.entityToModel(requestCustomer.getProfessionType()),
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
