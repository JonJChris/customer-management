package com.management.customer.service;

import com.management.customer.entity.authrisation.User;
import com.management.customer.entity.store.AddressStore;
import com.management.customer.entity.store.CustomerStore;
import com.management.customer.entity.store.DocumentStore;
import com.management.customer.entity.store.ProductStore;
import com.management.customer.entity.transaction.*;
import com.management.customer.entity.workflow.StageWorkflowRules;
import com.management.customer.enums.StageTypeEnum;
import com.management.customer.model.master.RequestStageModel;
import com.management.customer.enums.StageActionEnum;
import com.management.customer.model.transaction.request.RequestModel;
import com.management.customer.exceptions.NoDataFoundException;
import com.management.customer.model.userInterface.UIFieldModel;
import com.management.customer.repository.request.CustomerRepository;
import com.management.customer.repository.request.RequestRepository;
import com.management.customer.repository.store.CustomerStoreRepository;
import com.management.customer.tranformer.transaction.RequestTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RequestService {
    @Autowired
    RequestRepository requestRepository;
    @Autowired
    UserInterfaceService userInterfaceService;
    @Autowired
    WorkflowService workflowService;
    @Autowired
    MergeService mergeService;
    @Autowired
    AuthorisationService authorisationService;
    @Autowired
    CustomerStoreRepository customerStoreRepository;


    public RequestModel getRequestDetails(Long requestId) {
        Optional<Request> request = requestRepository.findById(requestId);

        if (request.isEmpty()) {
            throw new NoDataFoundException("Request Not Found");
        } else {
            Request requestEntity = request.get();
            Optional<List<UIFieldModel>> uiInputFieldRules = userInterfaceService.getRequestDetailsUIInputFieldRules(requestEntity.getRequestType(), requestEntity.getStageType());
            Optional<List<UIFieldModel>> uiTabRules = userInterfaceService.getRequestDetailsUITabFieldRules(requestEntity.getRequestType(), requestEntity.getStageType());
            Optional<List<UIFieldModel>> uiButtonRules = userInterfaceService.getRequestDetailsUIButtonFieldRules(requestEntity.getRequestType(), requestEntity.getStageType());
            return RequestTransformer.entityToModel(requestEntity,
                    uiInputFieldRules.orElse(null),
                    uiTabRules.orElse(null),
                    uiButtonRules.orElse(null)
            );
        }
    }


    public RequestStageModel getNextRequestStage(Long requestId) {
        Optional<Request> request = requestRepository.findById(requestId);
        if (request.isEmpty()) {
            throw new NoDataFoundException("Request Not Found");
        }
        Request requestEntity = request.get();
        return workflowService.getNextStageModel(requestEntity.getRequestType(), requestEntity.getStageType(), StageActionEnum.SUCCESS.name());

    }

    public RequestModel submitRequest(RequestModel requestModel) {
        Integer userId = requestModel.requestSubmittedBy().userId();
        Optional<Request> requestOptional = requestRepository.findById(requestModel.requestId());
        if (requestOptional.isEmpty()) {
            throw new NoDataFoundException("Request Not Found");
        }
        Request requestEntity = requestOptional.get();

        // get next request stage
        Optional<StageWorkflowRules> nextStageOptional = workflowService.getNextStageEntity(requestEntity.getRequestType(), requestEntity.getStageType(), StageActionEnum.SUCCESS.name());
        if (nextStageOptional.isEmpty()) {
            throw new NoDataFoundException("Next Request Stage Not Found");
        }
        StageWorkflowRules transitStageEntity = nextStageOptional.get();

        User userEntity = authorisationService.getUserEntity(userId).orElse(null);

        // merge data
        mergeService.mergeRequestModelWithEntity(requestEntity, requestModel, userEntity);

        // update request stage
        requestEntity.setStageType(transitStageEntity.getNextStageType());

        //save request data
        Request savedRequest = requestRepository.save(requestEntity);

        // update request stage to complete
        workflowService.updateRequestStages(savedRequest, transitStageEntity.getCurrentStageType(), transitStageEntity.getNextStageType(), userEntity);

        //TODO
        Optional<List<UIFieldModel>> uiInputFieldRules = userInterfaceService.getRequestDetailsUIInputFieldRules(requestEntity.getRequestType(), requestEntity.getStageType());
        Optional<List<UIFieldModel>> uiTabRules = userInterfaceService.getRequestDetailsUITabFieldRules(requestEntity.getRequestType(), requestEntity.getStageType());
        Optional<List<UIFieldModel>> uiButtonRules = userInterfaceService.getRequestDetailsUIButtonFieldRules(requestEntity.getRequestType(), requestEntity.getStageType());

        persistDataCustomerStore(savedRequest);

        return RequestTransformer.entityToModel(savedRequest,
                uiInputFieldRules.orElse(null),
                uiTabRules.orElse(null),
                uiButtonRules.orElse(null)
        );

    }

    private void persistDataCustomerStore(Request request) {
        if (request.getStageType().getStageName().equals("Closed")) {
            Long customerId = request.getRequestCustomer().getCustomerId();
            Optional<CustomerStore> customerStoreOptional = customerStoreRepository.findById(customerId);


            CustomerStore customerStore = null;
            customerStore = customerStoreOptional.orElseGet(() -> {
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
            customerStoreRepository.save(customerStore);

    }

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
        addressStore.setRegisteredAddressLine1(requestAddress.getRegisteredAddressLine1());
        addressStore.setCommunicationAddressLine1(requestAddress.getCommunicationAddressLine1());
        addressStore.setCommunicationAddressLine2(requestAddress.getCommunicationAddressLine1());
        addressStore.setCommunicationAddressLine1(requestAddress.getCommunicationAddressCity());
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
                newProductToAdd.setProductId(requestItem.getProductId());
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
