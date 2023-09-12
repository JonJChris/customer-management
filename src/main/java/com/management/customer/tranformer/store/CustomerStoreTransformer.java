package com.management.customer.tranformer.store;

import com.management.customer.entity.store.CustomerStore;
import com.management.customer.entity.transaction.Request;
import com.management.customer.model.transaction.store.CustomerStoreModel;
import com.management.customer.tranformer.master.*;
import com.management.customer.tranformer.transaction.UserTransformer;

import java.util.List;

public class CustomerStoreTransformer {
    public static CustomerStoreModel entityToModel(CustomerStore customerStore, List<Request> requestList) {
        return new CustomerStoreModel(
                customerStore.getCustomerId(),
                TitleTypeTransformer.entityToModel(customerStore.getTitleType()),
                customerStore.getFirstname(),
                customerStore.getLastName(),
                customerStore.getDisplayName(),
                CountryTypeTransformer.entityToModel(customerStore.getNationality()),
                customerStore.getEmail(),
                customerStore.getDateOfBirth(),
                MaritalStatusTypeTransformer.entityToModel(customerStore.getMaritalStatusType()),
                CustomerTypeTransformer.entityToModel(customerStore.getCustomerType()),
                EducationLevelTypeTransformer.entityToModel(customerStore.getEducationLeveltype()),
                ProfessionTypeTransformer.entityToModel(customerStore.getProfessionType()),
                customerStore.getOrganisationName(),
                YearlyIncomeTransformer.entityToModel(customerStore.getYearlyIncome()),
                RelationshipTypeTransformer.entityToModel(customerStore.getNomineeRelationshipType()),
                customerStore.getNomineeFirstName(),
                customerStore.getNomineeLastName(),
                customerStore.getDateOfBirth(),
                HomeOwnershipTypeTransformer.entityToModel(customerStore.getHomeOwnershipType()),
                customerStore.getCreatedDate(),
                UserTransformer.entityToModel(customerStore.getCreatedBy()),
                customerStore.getUpdatedDate(),
                UserTransformer.entityToModel(customerStore.getAddressStore().getUpdatedBy()),
                AddressStoreTransformer.entityToModel(customerStore.getAddressStore()),
                requestList.stream().map(RequestStoreTransformer::entityToModel).toList()
        );
    }
}
