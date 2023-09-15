package com.management.customer.service;

import com.management.customer.entity.authrisation.User;
import com.management.customer.entity.master.*;
import com.management.customer.entity.store.CustomerStore;
import com.management.customer.entity.transaction.*;
import com.management.customer.model.store.AddressStoreModel;
import com.management.customer.model.store.CustomerStoreModel;
import com.management.customer.model.store.DocumentStoreModel;
import com.management.customer.model.store.ProductStoreModel;
import com.management.customer.model.transaction.request.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.util.stream.Collectors.toList;

@Service
public class MergeService {
    @Autowired
    MasterDataService masterDataService;
    @Autowired
    AuthorisationService authorisationService;
    void mergeRequestModelWithEntity(Request requestEntity, RequestModel requestModel, User userEntity){
        mergeCustomerModelWithEntity(requestEntity.getRequestCustomer(), requestModel.customerModel(), userEntity);
        mergeAddressModelWithEntity(requestEntity.getRequestAddress(), requestModel.addressModel(), userEntity);
        mergeProductModelWithEntity(requestEntity, requestEntity.getProductRelationshipList(), requestModel.productRelationshipModelList(), userEntity);
        mergeDocumentModelWithEntity(requestEntity, requestEntity.getDocumentListList(), requestModel.documentModelList(), userEntity);
    }
    void mergeAddressModelWithEntity(RequestAddress requestAddressEntity, AddressModel addressModel, User userEntity){
        if(addressModel.registeredAddressCountry() != null)
            requestAddressEntity.setRegisteredAddressCountryType(masterDataService.getCountryEntity(addressModel.registeredAddressCountry()).orElse(null));

        if(addressModel.communicationAddressCountry() != null)
            requestAddressEntity.setCommunicationAddressCountryType(masterDataService.getCountryEntity(addressModel.communicationAddressCountry()).orElse(null));

        requestAddressEntity.setRegisteredAddressLine1(addressModel.registeredAddressLine1());
        requestAddressEntity.setRegisteredAddressLine2(addressModel.registeredAddressLine2());
        requestAddressEntity.setRegisteredAddressCity(addressModel.registeredAddressCity());
        requestAddressEntity.setRegisteredAddressState(addressModel.registeredAddressState());
        requestAddressEntity.setRegisteredAddressPostalCode(addressModel.registeredAddressPostalCode());
        requestAddressEntity.setCommunicationAddressLine1(addressModel.communicationAddressLine1());
        requestAddressEntity.setCommunicationAddressLine2(addressModel.communicationAddressLine2());
        requestAddressEntity.setCommunicationAddressCity(addressModel.communicationAddressCity());
        requestAddressEntity.setCommunicationAddressState(addressModel.communicationAddressState());
        requestAddressEntity.setCommunicationAddressPostalCode(addressModel.communicationAddressPostalCode());
        requestAddressEntity.setUpdatedDate(LocalDateTime.now());
        requestAddressEntity.setUpdatedBy(userEntity);

    }

    void mergeProductModelWithEntity(Request request, List<RequestProductRelationship> productRelationship, List<ProductRelationshipModel> productRelationshipModel, User userEntity){
        Random rand = new Random();
        List<RequestProductRelationship> itemsToAdd = new ArrayList<>();
        List<RequestProductRelationship> itemsToRemove = new ArrayList<>();

        for(RequestProductRelationship relationship: productRelationship){
            boolean missing = productRelationshipModel.stream().filter(item -> relationship.getId().equals(item.id())).findAny().isEmpty();
            if(missing){
                itemsToRemove.add(relationship);
            }
        }
        for(ProductRelationshipModel relationshipModel: productRelationshipModel){
            boolean missing = productRelationship.stream().filter(item ->
                    item.getProductType().getId().equals(relationshipModel.productType().productTypeId())
                    && item.getBranchType().getId().equals(relationshipModel.productBranch().branchTypeId()
                    )).findAny().isEmpty();
            if(missing){
                RequestProductRelationship newRelationship = new RequestProductRelationship();
                ProductType newProducttype = new ProductType();
                newProducttype.setId(relationshipModel.productType().productTypeId());
                BranchType newBranchtype = new BranchType();
                newBranchtype.setId(relationshipModel.productBranch().branchTypeId());
                newRelationship.setProductType(newProducttype);
                newRelationship.setBranchType(newBranchtype);
                String newAccNumber = String.valueOf(rand.nextLong(9000000) + 10000000);
                newRelationship.setAccountId(newAccNumber);
                newRelationship.setCreatedDate(LocalDateTime.now());
                newRelationship.setUpdatedDate(LocalDateTime.now());
                newRelationship.setCreatedBy(userEntity);
                newRelationship.setUpdatedBy(userEntity);
                newRelationship.setRequest(request);
                itemsToAdd.add(newRelationship);
            }
        }
        productRelationship.removeAll(itemsToRemove);
        productRelationship.addAll(itemsToAdd);


    }

    void mergeDocumentModelWithEntity(Request request, List<RequestDocument> requestDocuments, List<DocumentModel> documentModelList, User userEntity){
        Random rand = new Random();
        List<RequestDocument> itemsToAdd = new ArrayList<>();
        List<RequestDocument> itemsToRemove = new ArrayList<>();
        //loop entity compare model
        for(RequestDocument documentEntity: requestDocuments){
            boolean missing = documentModelList.stream().filter(item -> documentEntity.getId().equals(item.id())).findAny().isEmpty();
            if(missing){
                itemsToRemove.add(documentEntity);
            }
        }
        //loop model compare entity
        for(DocumentModel documentModel: documentModelList){
            boolean missing = requestDocuments.stream().filter(item ->
                    item.getDocumentType().getId().equals(documentModel.documentType().documentTypeId())
                    ).findAny().isEmpty();
            if(missing){

                RequestDocument newDocument = new RequestDocument();
                DocumentType newDocumentType = new DocumentType();
                newDocumentType.setId(documentModel.documentType().documentTypeId());
                newDocument.setDocumentLinkPath(documentModel.documentLinkPath());
                newDocument.setDocumentType(newDocumentType);
                newDocument.setRequest(request);
                newDocument.setCreatedDate(LocalDateTime.now());
                newDocument.setUpdatedDate(LocalDateTime.now());
                newDocument.setCreatedBy(userEntity);
                newDocument.setUpdatedBy(userEntity);
                itemsToAdd.add(newDocument);
            }
        }
        requestDocuments.removeAll(itemsToRemove);
        requestDocuments.addAll(itemsToAdd);


    }
    void mergeCustomerModelWithEntity(RequestCustomer requestCustomerEntity, CustomerModel customerModel, User userEntity){
        if(customerModel.customerType() != null)
            requestCustomerEntity.setCustomerType(masterDataService.getCustomerTypeEntity(customerModel.customerType()).orElse(null));

        if(customerModel.userTitle() != null)
            requestCustomerEntity.setTitleType(masterDataService.getTitleEntity(customerModel.userTitle()).orElse(null));

        if(customerModel.nationality() != null)
            requestCustomerEntity.setNationality(masterDataService.getCountryEntity(customerModel.nationality()).orElse(null));

        if(customerModel.maritalStatus() != null)
            requestCustomerEntity.setMaritalStatusType(masterDataService.getMartialStatusEntity(customerModel.maritalStatus()).orElse(null));

        if(customerModel.customerEducationLevel() != null)
            requestCustomerEntity.setEducationLeveltype(masterDataService.getEducationLevelEntity(customerModel.customerEducationLevel()).orElse(null));

        if(customerModel.customerProfession() != null)
            requestCustomerEntity.setProfessionType(masterDataService.getProfessionEntity(customerModel.customerProfession()).orElse(null));

        if(customerModel.customerYearlyIncome() != null)
            requestCustomerEntity.setYearlyIncome(masterDataService.getYearlyIncomeEntity(customerModel.customerYearlyIncome()).orElse(null));

        if(customerModel.nomineeRelationshipType() != null)
            requestCustomerEntity.setNomineeRelationshipType(masterDataService.getRelationshipTypeEntity(customerModel.nomineeRelationshipType()).orElse(null));

        if(customerModel.homeOwnershipType() != null)
            requestCustomerEntity.setHomeOwnershipType(masterDataService.getHomeOwnershipTypeEntity(customerModel.homeOwnershipType()).orElse(null));

        requestCustomerEntity.setFirstname(customerModel.firstName());
        requestCustomerEntity.setLastName(customerModel.lastName());
        requestCustomerEntity.setDisplayName(customerModel.displayName());
        requestCustomerEntity.setEmail(customerModel.email());
        requestCustomerEntity.setDateOfBirth(customerModel.dateOfBirth());
        requestCustomerEntity.setOrganisationName(customerModel.customerOrganisationName());
        requestCustomerEntity.setNomineeFirstName(customerModel.nomineeFirstName());
        requestCustomerEntity.setNomineeLastName(customerModel.nomineeLastName());
        requestCustomerEntity.setNomineeDateOfBirth(customerModel.nomineeDateOfBirth());
        requestCustomerEntity.setUpdatedDate(LocalDateTime.now());
        requestCustomerEntity.setUpdatedBy(userEntity);



    }

    public void mergeCustomerStoreToRequestCustomer(CustomerStoreModel customerStoreModel, RequestCustomer requestCustomer, Request request, User currentUser){
        requestCustomer.setRequest(request);
        requestCustomer.setUpdatedBy(currentUser);
        requestCustomer.setUpdatedDate(LocalDateTime.now());

        if(customerStoreModel != null){

        requestCustomer.setCustomerId(customerStoreModel.customerId());
        requestCustomer.setTitleType(customerStoreModel.userTitle() != null ? new TitleType(customerStoreModel.userTitle().titleId(), customerStoreModel.userTitle().titleName()): null);
        requestCustomer.setFirstname(customerStoreModel.firstName());
        requestCustomer.setLastName(customerStoreModel.lastName());
        requestCustomer.setDisplayName(customerStoreModel.displayName());
        requestCustomer.setNationality(customerStoreModel.nationality() != null ? new CountryType(customerStoreModel.nationality().countryId(), customerStoreModel.nationality().countryName()): null);
        requestCustomer.setEmail(customerStoreModel.email());
        requestCustomer.setDateOfBirth(customerStoreModel.dateOfBirth());
        requestCustomer.setMaritalStatusType(customerStoreModel.maritalStatus() != null ? new MaritalStatusType(customerStoreModel.maritalStatus().maritalStatusId(), customerStoreModel.maritalStatus().maritalStatusName()): null);
        requestCustomer.setCustomerType(customerStoreModel.customerType() != null ? new CustomerType(customerStoreModel.customerType().customerTypeId(), customerStoreModel.customerType().customerTypeName()): null);
        requestCustomer.setEducationLeveltype(customerStoreModel.customerEducationLevel() != null ? new EducationLevelType(customerStoreModel.customerEducationLevel().educationLevelId(), customerStoreModel.customerEducationLevel().educationLevelName()): null);
        requestCustomer.setProfessionType(customerStoreModel.customerProfession() != null ? new ProfessionType(customerStoreModel.customerProfession().professionId(), customerStoreModel.customerProfession().professionName()): null);
        requestCustomer.setOrganisationName(customerStoreModel.customerOrganisationName());
        requestCustomer.setYearlyIncome(customerStoreModel.customerYearlyIncome() != null ? new YearlyIncomeType(customerStoreModel.customerYearlyIncome().yearlyIncomeId(), customerStoreModel.customerYearlyIncome().yearlyIncomeName()): null);
        requestCustomer.setNomineeRelationshipType(customerStoreModel.nomineeRelationshipType() != null ? new RelationshipType(customerStoreModel.nomineeRelationshipType().relationshipTypeId(), customerStoreModel.nomineeRelationshipType().relationshipTypeName()): null);
        requestCustomer.setNomineeFirstName(customerStoreModel.nomineeFirstName());
        requestCustomer.setNomineeLastName(customerStoreModel.nomineeLastName());
        requestCustomer.setNomineeDateOfBirth(customerStoreModel.nomineeDateOfBirth());
        requestCustomer.setHomeOwnershipType(customerStoreModel.homeOwnershipType() != null ? new HomeOwnershipType(customerStoreModel.homeOwnershipType().homeOwnershipTypeId(), customerStoreModel.homeOwnershipType().homeOwnershipTypeName()): null);
        requestCustomer.setCreatedBy(customerStoreModel.createdBy() != null ? new User(customerStoreModel.createdBy().userId(), customerStoreModel.createdBy().username(), customerStoreModel.createdBy().userFirstName(), customerStoreModel.createdBy().userLastName()) : null);
        requestCustomer.setCreatedDate(customerStoreModel.createdDate());
        }else{
            requestCustomer.setCreatedDate(LocalDateTime.now());
            requestCustomer.setCreatedBy(currentUser);
        }
    }
    public void mergeAddressStoreToRequestCustomer(AddressStoreModel addressStoreModel, RequestAddress requestAddress, Request request, User currentUser){
        requestAddress.setRequest(request);
        requestAddress.setUpdatedBy(currentUser);
        requestAddress.setUpdatedDate(LocalDateTime.now());
        if(addressStoreModel != null) {
            requestAddress.setAddressId(addressStoreModel.addressId());
            requestAddress.setRegisteredAddressLine1(addressStoreModel.registeredAddressLine1());
            requestAddress.setRegisteredAddressLine2(addressStoreModel.registeredAddressLine2());
            requestAddress.setRegisteredAddressCity(addressStoreModel.registeredAddressCity());
            requestAddress.setRegisteredAddressState(addressStoreModel.registeredAddressState());
            requestAddress.setRegisteredAddressPostalCode(addressStoreModel.registeredAddressPostalCode());
            requestAddress.setRegisteredAddressCountryType(addressStoreModel.registeredAddressCountry() != null ? new CountryType(addressStoreModel.registeredAddressCountry().countryId(), addressStoreModel.registeredAddressCountry().countryName()) : null);

            requestAddress.setCommunicationAddressLine1(addressStoreModel.communicationAddressLine1());
            requestAddress.setCommunicationAddressLine2(addressStoreModel.communicationAddressLine2());
            requestAddress.setCommunicationAddressCity(addressStoreModel.communicationAddressCity());
            requestAddress.setCommunicationAddressState(addressStoreModel.communicationAddressState());
            requestAddress.setCommunicationAddressPostalCode(addressStoreModel.communicationAddressLine1());
            requestAddress.setCommunicationAddressCountryType(addressStoreModel.communicationAddressCountry() != null ? new CountryType(addressStoreModel.communicationAddressCountry().countryId(), addressStoreModel.communicationAddressCountry().countryName()) : null);

            requestAddress.setCreatedBy(addressStoreModel.createdBy() != null ? new User(addressStoreModel.createdBy().userId(), addressStoreModel.createdBy().username(), addressStoreModel.createdBy().userFirstName(), addressStoreModel.createdBy().userLastName()) : null);
            requestAddress.setCreatedDate(addressStoreModel.createdDate());
        }else{
            requestAddress.setCreatedDate(LocalDateTime.now());
            requestAddress.setCreatedBy(currentUser);
        }
    }
    public void mergeProductStoreListToRequestProductsList(List<ProductStoreModel> productStoreModelList , List<RequestProductRelationship> requestProductRelationshipList, Request request, User currentUser){

        if(productStoreModelList != null){
        if(!productStoreModelList.isEmpty()) {
            List<RequestProductRelationship> returnList = productStoreModelList.stream().map(productItem ->
                    new RequestProductRelationship(
                            null,
                            productItem.productId(),
                            productItem.accountId(),
                            request,
                            productItem.productType() != null ? new ProductType(productItem.productType().productTypeId(), productItem.productType().productTypeCode(), productItem.productType().productTypeName(), productItem.productType().productTypeDescription()) : null,
                            productItem.productBranch() != null ? new BranchType(productItem.productBranch().branchTypeId(), productItem.productBranch().branchTypeCode(), productItem.productBranch().branchTypeName(), productItem.productBranch().branchTypeDescription()) : null,
                            productItem.createdDate(),
                            productItem.createdBy() != null ? new User(productItem.createdBy().userId(), productItem.createdBy().username(), productItem.createdBy().userFirstName(), productItem.createdBy().userLastName()) : null,
                            LocalDateTime.now(),
                            currentUser
                    )
            ).toList();

            requestProductRelationshipList.addAll(returnList);
        }
        }
    }
    public void mergeDocumentStoreListToRequestDocumentsList(List<DocumentStoreModel> documentStoreModelList , List<RequestDocument> requestDocumentList, Request request, User currentUser){
        if(documentStoreModelList != null) {
            if (!documentStoreModelList.isEmpty()) {
                List<RequestDocument> returnList = documentStoreModelList.stream().map(documentItem ->
                        new RequestDocument(
                                null,
                                documentItem.documentId(),
                                request,
                                documentItem.documentType() != null ? new DocumentType(documentItem.documentType().documentTypeId(), documentItem.documentType().documentTypeName(), documentItem.documentType().documentTypeName()) : null,
                                documentItem.documentLinkPath(),
                                documentItem.createdDate(),
                                documentItem.createdBy() != null ? new User(documentItem.createdBy().userId(), documentItem.createdBy().username(), documentItem.createdBy().userFirstName(), documentItem.createdBy().userLastName()) : null,
                                LocalDateTime.now(),
                                currentUser
                        )
                ).toList();

                requestDocumentList.addAll(returnList);
            }
        }
    }


}


