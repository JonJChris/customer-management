package com.management.customer.service;

import com.management.customer.entity.authrisation.User;
import com.management.customer.entity.master.BranchType;
import com.management.customer.entity.master.DocumentType;
import com.management.customer.entity.master.ProductType;
import com.management.customer.entity.transaction.*;
import com.management.customer.model.transaction.request.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

}
