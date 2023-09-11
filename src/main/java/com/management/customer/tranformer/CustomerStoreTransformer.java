package com.management.customer.tranformer;

import com.management.customer.entity.store.CustomerStore;
import com.management.customer.entity.transaction.Request;
import com.management.customer.model.transaction.request.CustomerModel;
import com.management.customer.model.transaction.store.CustomerStoreModel;

import java.util.List;

public class CustomerStoreTransformer {
    public static CustomerStoreModel entityToModel(CustomerStore customerStore, List<Request> requestList) {
        return new CustomerStoreModel(
                customerStore.getCustomerId(),
                TitleTransformer.entityToModel(customerStore.getTitleType()),
                customerStore.getFirstname(),
                customerStore.getLastName(),
                customerStore.getDisplayName(),
                CountryTransformer.entityToModel(customerStore.getNationality()),
                customerStore.getEmail(),
                customerStore.getDateOfBirth(),
                MaritalStatusTransformer.entityToModel(customerStore.getMaritalStatusType()),
                CustomerTypeTransformer.entityToModel(customerStore.getCustomerType()),
                EducationLevelTransformer.entityToModel(customerStore.getEducationLeveltype()),
                ProfessionTransformer.entityToModel(customerStore.getProfessionType()),
                customerStore.getOrganisationName(),
                YearlyIncomeTransformer.entityToModel(customerStore.getYearlyIncome()),
                RelationshipTypeTransformer.entityToModel(customerStore.getNomineeRelationshipType()),
                customerStore.getNomineeFirstName(),
                customerStore.getNomineeLastName(),
                customerStore.getDateOfBirth(),
                HomeOwnershipTypeTransformer.entityToModel(customerStore.getHomeOwnershipType()),
                customerStore.getCreatedOn(),
                UserTransformer.entityToModel(customerStore.getCreatedBy()),
                customerStore.getUpdatedOn(),
                UserTransformer.entityToModel(customerStore.getAddressStore().getUpdatedBy()),
                AddressStoreTransformer.entityToModel(customerStore.getAddressStore()),
                requestList.stream().map(RequestStoreTransformer::entityToModel).toList()
        );
    }
}
