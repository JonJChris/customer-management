package com.management.customer.tranformer.transaction;

import com.management.customer.model.transaction.request.CustomerModel;
import com.management.customer.entity.transaction.RequestCustomer;
import com.management.customer.tranformer.master.*;

import java.util.Objects;

public class CustomerTransformer {
    public static CustomerModel entityToModel(RequestCustomer requestCustomer){
        return new CustomerModel(
                requestCustomer.getCustomerId(),
                Objects.isNull(requestCustomer.getTitleType()) ? null :TitleTypeTransformer.entityToModel(requestCustomer.getTitleType()),
                requestCustomer.getFirstname(),
                requestCustomer.getLastName(),
                requestCustomer.getDisplayName(),
                Objects.isNull(requestCustomer.getNationality()) ? null :   CountryTypeTransformer.entityToModel(requestCustomer.getNationality()),
                requestCustomer.getEmail(),
                requestCustomer.getDateOfBirth(),
                Objects.isNull(requestCustomer.getMaritalStatusType()) ? null :   MaritalStatusTypeTransformer.entityToModel(requestCustomer.getMaritalStatusType()),
                Objects.isNull(requestCustomer.getCustomerType()) ? null :   CustomerTypeTransformer.entityToModel(requestCustomer.getCustomerType()),
                Objects.isNull(requestCustomer.getEducationLeveltype()) ? null :   EducationLevelTypeTransformer.entityToModel(requestCustomer.getEducationLeveltype()),
                Objects.isNull(requestCustomer.getProfessionType()) ? null :   ProfessionTypeTransformer.entityToModel(requestCustomer.getProfessionType()),
                requestCustomer.getOrganisationName(),
                Objects.isNull(requestCustomer.getYearlyIncome()) ? null :   YearlyIncomeTransformer.entityToModel(requestCustomer.getYearlyIncome()),
                Objects.isNull(requestCustomer.getNomineeRelationshipType()) ? null :   RelationshipTypeTransformer.entityToModel(requestCustomer.getNomineeRelationshipType()),
                requestCustomer.getNomineeFirstName(),
                requestCustomer.getNomineeLastName(),
                requestCustomer.getDateOfBirth(),
                Objects.isNull(requestCustomer.getHomeOwnershipType()) ? null :   HomeOwnershipTypeTransformer.entityToModel(requestCustomer.getHomeOwnershipType())
                );

    }




}
