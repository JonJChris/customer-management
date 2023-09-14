package com.management.customer.tranformer.store;

import com.management.customer.entity.store.CustomerStore;
import com.management.customer.entity.transaction.Request;
import com.management.customer.model.store.CustomerStoreModel;
import com.management.customer.tranformer.master.*;
import com.management.customer.tranformer.transaction.UserTransformer;

import java.util.List;

public class CustomerStoreTransformer {
    public static CustomerStoreModel entityToModel(CustomerStore customerStore, List<Request> requestList) {
        return new CustomerStoreModel(
                customerStore.getCustomerId(),
                customerStore.getTitleType() != null ? TitleTypeTransformer.entityToModel(customerStore.getTitleType()): null,
                customerStore.getFirstname(),
                customerStore.getLastName(),
                customerStore.getDisplayName(),
                customerStore.getNationality() != null ? CountryTypeTransformer.entityToModel(customerStore.getNationality()): null,
                customerStore.getEmail(),
                customerStore.getDateOfBirth(),
                customerStore.getMaritalStatusType() != null ? MaritalStatusTypeTransformer.entityToModel(customerStore.getMaritalStatusType()): null,
                customerStore.getCustomerType() != null ? CustomerTypeTransformer.entityToModel(customerStore.getCustomerType()) :null,
                customerStore.getEducationLeveltype() != null ? EducationLevelTypeTransformer.entityToModel(customerStore.getEducationLeveltype()): null,
                customerStore.getProfessionType() != null ? ProfessionTypeTransformer.entityToModel(customerStore.getProfessionType()): null,
                customerStore.getOrganisationName(),
                customerStore.getYearlyIncome() != null ? YearlyIncomeTransformer.entityToModel(customerStore.getYearlyIncome()) : null,
                customerStore.getNomineeRelationshipType() != null ? RelationshipTypeTransformer.entityToModel(customerStore.getNomineeRelationshipType()) : null,
                customerStore.getNomineeFirstName(),
                customerStore.getNomineeLastName(),
                customerStore.getDateOfBirth(),
                customerStore.getHomeOwnershipType() != null ? HomeOwnershipTypeTransformer.entityToModel(customerStore.getHomeOwnershipType()) : null,
                customerStore.getAddressStore() != null ?AddressStoreTransformer.entityToModel(customerStore.getAddressStore()) : null,
                customerStore.getProductStoreList().stream().map(ProductStoreTransformer::entityToModel).toList(),
                customerStore.getDocumentStoreList().stream().map(DocumentStoreTransformer::entityToModel).toList(),
                requestList.stream().map(RequestStoreTransformer::entityToModel).toList(),
                customerStore.getCreatedDate(),
                customerStore.getCreatedBy() != null ? UserTransformer.entityToModel(customerStore.getCreatedBy()) : null,
                customerStore.getUpdatedDate(),
                customerStore.getAddressStore() != null ? UserTransformer.entityToModel(customerStore.getAddressStore().getUpdatedBy()) : null

        );
    }
}
