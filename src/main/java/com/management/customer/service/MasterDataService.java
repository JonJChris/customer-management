package com.management.customer.service;

import com.management.customer.dto.*;
import com.management.customer.entity.lookup.*;
import com.management.customer.repository.master.*;
import com.management.customer.tranformer.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MasterDataService {
    @Autowired
    RequestTypeRepository requestTypeRepository;
    @Autowired
    RequestStageRepository requestStageRepository;
    @Autowired
    CustomerTypeRepository customerTypeRepository;
    @Autowired
    CustomerStatusRepository customerStatusRepository;
    @Autowired
    CountryRepository countryRepository;
    @Autowired
    EducationLevelRepository educationLevelRepository;
    @Autowired
    EmploymentStatusRepository employmentStatusRepository;
    @Autowired
    MaritalStatusRepository maritalStatusRepository;
    @Autowired
    ProfessionRepository professionRepository;
    @Autowired
    TitleRepository titleRepository;
    @Autowired
    YearlyIncomeRepository yearlyIncomeRepository;
    @Autowired
    UserInterfaceRulesRepository userInterfaceRulesRepository;

    @Autowired
    RelationshipTypeRepository relationshipTypeRepository;
    @Autowired
    HomeOwnershipTypeRepository homeOwnershipTypeRepository;

    public List<RequestTypeDTO> getRequestTypeList(){
        List<RequestType> requestTypesEntityList = requestTypeRepository.findAll();
        return requestTypesEntityList.stream().map(RequestTypeTransformer::entityToModel).toList();
    }
    public List<RequestStageDTO> getRequestStageList(){
        List<RequestStage> requestStageEntityList = requestStageRepository.findAll();
        return requestStageEntityList.stream().map(RequestStageTransformer::entityToModel).toList();
    }
    public List<CountryDTO> getCountryList(){
        List<Country> countryEntityList = countryRepository.findAll();
        return countryEntityList.stream().map(CountryTransformer::entityToModel).toList();
    }

    public List<CustomerStatusDTO> getCustomerStatusList(){
        List<CustomerStatus> customerStatusEntityList = customerStatusRepository.findAll();
        return customerStatusEntityList.stream().map(CustomerStatusTransformer::entityToModel).toList();
    }
    public List<CustomerTypeDTO> getCustomerTypeList(){
        List<CustomerType> customerTypeEntityList = customerTypeRepository.findAll();
        return customerTypeEntityList.stream().map(CustomerTypeTransformer::entityToModel).toList();
    }

    public List<EducationLevelDTO> getEducationLevelList(){
        List<EducationLevel> educationLevelREntityList = educationLevelRepository.findAll();
        return educationLevelREntityList.stream().map(EducationLevelTransformer::entityToModel).toList();
    }
    public List<EmploymentStatusDTO> getEmploymentStatusList(){
        List<EmploymentStatus> employmentStatusEntityList = employmentStatusRepository.findAll();
        return employmentStatusEntityList.stream().map(EmploymentStatusTransformer::entityToModel).toList();
    }
    public List<MaritalStatusDTO> getMaritalStatusList(){
        List<MaritalStatus> martialStatusntityList = maritalStatusRepository.findAll();
        return martialStatusntityList.stream().map(MaritalStatusTransformer::entityToModel).toList();
    }
    public List<ProfessionDTO> getProfessionsList(){
        List<Profession> professionEntityList = professionRepository.findAll();
        return professionEntityList.stream().map(ProfessionTransformer::entityToModel).toList();
    }
    public List<TitleDTO> getTitlesList(){
        List<Title> titleEntityList = titleRepository.findAll();
        return titleEntityList.stream().map(TitleTransformer::entityToModel).toList();
    }
    public List<YearlyIncomeDTO> getYearlyIncomesList(){
        List<YearlyIncome> yearlyIncomeEntityList = yearlyIncomeRepository.findAll();
        return yearlyIncomeEntityList.stream().map(YearlyIncomeTransformer::entityToModel).toList();
    }
    public List<UserInterfaceRuleDTO> getUserInterfaceRules(){
        List<UIFieldRules> userInterfaceEntityList = userInterfaceRulesRepository.findAll();
        return userInterfaceEntityList.stream().map(UserInterfaceRulesTransformer::entityToModel).toList();
    }
    public List<RelationshipTypeDTO> getRelationshipTypesList(){
        List<RelationshipType> relationshipTypesEntityList = relationshipTypeRepository.findAll();
        return relationshipTypesEntityList.stream().map(RelationshipTypeTransformer::entityToModel).toList();
    }
    public List<HomeOwnershipTypeDTO> getHomeOwnershipTypesList(){
        List<HomeOwnershipType> homeOwnershipTypesEntityList = homeOwnershipTypeRepository.findAll();
        return homeOwnershipTypesEntityList.stream().map(HomeOwnershipTypeTransformer::entityToModel).toList();
    }



}
