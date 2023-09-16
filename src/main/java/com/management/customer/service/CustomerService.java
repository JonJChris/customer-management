package com.management.customer.service;

import com.management.customer.entity.store.AddressStore;
import com.management.customer.entity.store.CustomerStore;
import com.management.customer.entity.store.DocumentStore;
import com.management.customer.entity.store.ProductStore;
import com.management.customer.entity.transaction.*;
import com.management.customer.exceptions.NoDataFoundException;
import com.management.customer.model.store.CustomerStoreModel;
import com.management.customer.repository.request.RequestRepository;
import com.management.customer.repository.store.CustomerStoreRepository;
import com.management.customer.tranformer.store.CustomerStoreTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    CustomerStoreRepository customerStoreRepository;
    @Autowired
    RequestRepository requestRepository;

    public CustomerStoreModel getCustomerDetails(Long customerId) {
        Optional<CustomerStore> customer = customerStoreRepository.findById(customerId);
        if (customer.isEmpty()) {
            throw new NoDataFoundException("Customer Not Found");
        } else {
            CustomerStore customerEntity = customer.get();
            Optional<List<Request>> requestListOptional = requestRepository.findByRequestCustomer_CustomerId(customerEntity.getCustomerId());
            return CustomerStoreTransformer.entityToModel(customerEntity, requestListOptional.orElse(Collections.emptyList()));
        }
    }


    public Long persistDataCustomerStore(Request request) {
        Long returnCustomerId = null;
        if (request.getStageType().getStageName().equals("Closed")) {
            Long customerId = request.getRequestCustomer().getCustomerId();

            Optional<CustomerStore> customerStoreOptional = Optional.empty();
            if(customerId != null){
                customerStoreOptional = customerStoreRepository.findById(customerId);
            }

           CustomerStore customerStore = customerStoreOptional.orElseGet(() -> {
                CustomerStore store = new CustomerStore();
                store.setCustomerId(request.getRequestCustomer().getCustomerId());
                store.setAddressStore(new AddressStore());
                store.setDocumentStoreList(new ArrayList<>());
                store.setProductStoreList(new ArrayList<>());
                return store;
            });


            mergeRequestCustomerToCustomerStore(customerStore, request.getRequestCustomer());
            mergeRequestAddressToAddressStore(customerStore.getAddressStore(), request.getRequestAddress(), customerStore);
            mergeRequestProductToProductStore(customerStore.getProductStoreList(), request.getProductRelationshipList(), customerStore);
            mergeRequestDocumentToDocumentStore(customerStore.getDocumentStoreList(), request.getDocumentListList(), customerStore);
            CustomerStore savedCustomer = customerStoreRepository.save(customerStore);
            returnCustomerId =  savedCustomer.getCustomerId();

        }
        return returnCustomerId;
    }

    private void mergeRequestCustomerToCustomerStore(CustomerStore customerStore, RequestCustomer requestCustomer) {
        customerStore.setTitleType(requestCustomer.getTitleType());
        customerStore.setFirstname(requestCustomer.getFirstname());
        customerStore.setLastName(requestCustomer.getLastName());
        customerStore.setDisplayName(requestCustomer.getDisplayName());
        customerStore.setNationality(requestCustomer.getNationality());
        customerStore.setEmail(requestCustomer.getEmail());
        customerStore.setDateOfBirth(requestCustomer.getDateOfBirth());
        customerStore.setMaritalStatusType(requestCustomer.getMaritalStatusType());
        customerStore.setCustomerType(requestCustomer.getCustomerType());
        customerStore.setEducationLeveltype(requestCustomer.getEducationLeveltype());
        customerStore.setProfessionType(requestCustomer.getProfessionType());
        customerStore.setOrganisationName(requestCustomer.getOrganisationName());
        customerStore.setYearlyIncome(requestCustomer.getYearlyIncome());
        customerStore.setNomineeRelationshipType(requestCustomer.getNomineeRelationshipType());
        customerStore.setNomineeFirstName(requestCustomer.getNomineeFirstName());
        customerStore.setNomineeLastName(requestCustomer.getNomineeLastName());
        customerStore.setNomineeDateOfBirth(requestCustomer.getNomineeDateOfBirth());
        customerStore.setHomeOwnershipType(requestCustomer.getHomeOwnershipType());
        customerStore.setCreatedDate(requestCustomer.getCreatedDate());
        customerStore.setCreatedBy(requestCustomer.getCreatedBy());
        customerStore.setUpdatedDate(LocalDateTime.now());
        customerStore.setUpdatedBy(requestCustomer.getUpdatedBy());
    }

    private void mergeRequestAddressToAddressStore(AddressStore addressStore, RequestAddress requestAddress, CustomerStore customerStore) {
        addressStore.setAddressId(requestAddress.getAddressId());
        addressStore.setCustomerId(customerStore);

        addressStore.setRegisteredAddressLine1(requestAddress.getRegisteredAddressLine1());
        addressStore.setRegisteredAddressLine2(requestAddress.getRegisteredAddressLine2());
        addressStore.setRegisteredAddressCity(requestAddress.getRegisteredAddressCity());
        addressStore.setRegisteredAddressState(requestAddress.getRegisteredAddressState());
        addressStore.setRegisteredAddressCountryType(requestAddress.getRegisteredAddressCountryType());
        addressStore.setRegisteredAddressPostalCode(requestAddress.getRegisteredAddressPostalCode());

        addressStore.setCommunicationAddressLine1(requestAddress.getCommunicationAddressLine1());
        addressStore.setCommunicationAddressLine2(requestAddress.getCommunicationAddressLine2());
        addressStore.setCommunicationAddressCity(requestAddress.getCommunicationAddressCity());
        addressStore.setCommunicationAddressState(requestAddress.getCommunicationAddressState());
        addressStore.setCommunicationAddressCountryType(requestAddress.getCommunicationAddressCountryType());
        addressStore.setCommunicationAddressPostalCode(requestAddress.getCommunicationAddressPostalCode());

        addressStore.setUpdatedDate(LocalDateTime.now());
        addressStore.setUpdatedBy(requestAddress.getUpdatedBy());
        addressStore.setCreatedDate(requestAddress.getCreatedDate());
        addressStore.setCreatedBy(requestAddress.getCreatedBy());
    }

    private void mergeRequestProductToProductStore(List<ProductStore> productStoreList, List<RequestProductRelationship> requestProductList, CustomerStore customerStore) {
        List<ProductStore> itemsToAdd = new ArrayList<>();
        List<ProductStore> itemsToRemove = new ArrayList<>();
        //loop request compare store
        for (RequestProductRelationship requestItem : requestProductList) {
            boolean missing = productStoreList.stream().filter(item -> item.getProductId().equals(requestItem.getProductId())).findAny().isEmpty();
            if (missing) {
                ProductStore newProductToAdd = new ProductStore();
                newProductToAdd.setProductId(requestItem.getId());
                newProductToAdd.setAccountId(requestItem.getAccountId());
                newProductToAdd.setProductType(requestItem.getProductType());
                newProductToAdd.setBranchType(requestItem.getBranchType());
                newProductToAdd.setCreatedDate(LocalDateTime.now());
                newProductToAdd.setCreatedBy(requestItem.getUpdatedBy());
                newProductToAdd.setUpdatedDate(LocalDateTime.now());
                newProductToAdd.setUpdatedBy(requestItem.getUpdatedBy());
                newProductToAdd.setCustomerId(customerStore);
                itemsToAdd.add(newProductToAdd);
            }
        }
        //loop store compare request
        for (ProductStore entityItem : productStoreList) {
            boolean missing = requestProductList.stream().filter(item -> item.getProductId().equals(entityItem.getProductId())).findAny().isEmpty();
            if (missing) {
                itemsToRemove.add(entityItem);
            }
        }
        productStoreList.addAll(itemsToAdd);
        productStoreList.removeAll(itemsToRemove);
    }

    private void mergeRequestDocumentToDocumentStore(List<DocumentStore> documentStoreList, List<RequestDocument> requestDocumentsList, CustomerStore customerStore) {
        List<DocumentStore> itemsToAdd = new ArrayList<>();
        List<DocumentStore> itemsToRemove = new ArrayList<>();
        //loop request compare store
        for (RequestDocument requestItem : requestDocumentsList) {
            boolean missing = documentStoreList.stream().filter(item -> item.getDocumentId().equals(requestItem.getDocumentId())).findAny().isEmpty();
            if (missing) {
                DocumentStore newDocumentToAdd = new DocumentStore();
                newDocumentToAdd.setDocumentId(requestItem.getDocumentId());
                newDocumentToAdd.setDocumentType(requestItem.getDocumentType());
                newDocumentToAdd.setDocumentLinkPath(requestItem.getDocumentLinkPath());
                newDocumentToAdd.setCreatedDate(LocalDateTime.now());
                newDocumentToAdd.setCreatedBy(requestItem.getCreatedBy());
                newDocumentToAdd.setUpdatedDate(LocalDateTime.now());
                newDocumentToAdd.setUpdatedBy(requestItem.getUpdatedBy());
                newDocumentToAdd.setCustomerId(customerStore);
                itemsToAdd.add(newDocumentToAdd);
            }
        }
        //loop store compare request
        for (DocumentStore entityItem : documentStoreList) {
            boolean missing = requestDocumentsList.stream().filter(item -> item.getDocumentId().equals(entityItem.getDocumentId())).findAny().isEmpty();
            if (missing) {
                itemsToRemove.add(entityItem);
            }
        }
        documentStoreList.addAll(itemsToAdd);
        documentStoreList.removeAll(itemsToRemove);
    }

}
