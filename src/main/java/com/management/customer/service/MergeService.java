package com.management.customer.service;

import com.management.customer.entity.authrisation.User;
import com.management.customer.entity.transaction.RequestAddress;
import com.management.customer.entity.transaction.RequestCustomer;
import com.management.customer.entity.transaction.Request;
import com.management.customer.model.transaction.request.AddressModel;
import com.management.customer.model.transaction.request.CustomerModel;
import com.management.customer.model.transaction.request.RequestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
@Service
public class MergeService {
    @Autowired
    MasterDataService masterDataService;
    @Autowired
    AuthorisationService authorisationService;
    void mergeRequestModelWithEntity(Request requestEntity, RequestModel requestModel, User userEntity){
        mergeCustomerModelWithEntity(requestEntity.getRequestCustomer(), requestModel.customerModel(), userEntity);
        mergeAddressModelWithEntity(requestEntity.getRequestAddress(), requestModel.addressModel(), userEntity);
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
        requestAddressEntity.setUpdatedOn(LocalDateTime.now());
        requestAddressEntity.setUpdatedBy(userEntity);

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
        requestCustomerEntity.setUpdatedOn(LocalDateTime.now());
        requestCustomerEntity.setUpdatedBy(userEntity);



    }

}
