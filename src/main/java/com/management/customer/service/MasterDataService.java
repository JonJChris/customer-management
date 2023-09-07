package com.management.customer.service;

import com.management.customer.model.master.*;
import com.management.customer.entity.master.*;
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

    @Autowired
    ProductRepository productRepository;

    @Autowired
    BranchRepository branchRepository;

    @Autowired
    DocumentTypeRepository documentTypeRepository;

    public MasterDataModel getMasterData(){
        return new MasterDataModel(getRequestTypeList(), getCountryList(), getCustomerStatusList(), getCustomerTypeList(), getEducationLevelList(),
                getEmploymentStatusList(), getMaritalStatusList(), getProfessionsList(), getRequestStageList(), getTitlesList(), getYearlyIncomesList(),
                getRelationshipTypesList(), getHomeOwnershipTypesList());

    }
    public List<RequestTypeModel> getRequestTypeList(){
        List<RequestType> requestTypesEntityList = requestTypeRepository.findAll();
        return requestTypesEntityList.stream().map(RequestTypeTransformer::entityToModel).toList();
    }
    public List<RequestStageModel> getRequestStageList(){
        List<RequestStage> requestStageEntityList = requestStageRepository.findAll();
        return requestStageEntityList.stream().map(RequestStageTransformer::entityToModel).toList();
    }
    public List<CountryModel> getCountryList(){
        List<Country> countryEntityList = countryRepository.findAll();
        return countryEntityList.stream().map(CountryTransformer::entityToModel).toList();
    }

    public List<CustomerStatusModel> getCustomerStatusList(){
        List<CustomerStatus> customerStatusEntityList = customerStatusRepository.findAll();
        return customerStatusEntityList.stream().map(CustomerStatusTransformer::entityToModel).toList();
    }
    public List<CustomerTypeModel> getCustomerTypeList(){
        List<CustomerType> customerTypeEntityList = customerTypeRepository.findAll();
        return customerTypeEntityList.stream().map(CustomerTypeTransformer::entityToModel).toList();
    }

    public List<EducationLevelModel> getEducationLevelList(){
        List<EducationLevel> educationLevelREntityList = educationLevelRepository.findAll();
        return educationLevelREntityList.stream().map(EducationLevelTransformer::entityToModel).toList();
    }
    public List<EmploymentStatusModel> getEmploymentStatusList(){
        List<EmploymentStatus> employmentStatusEntityList = employmentStatusRepository.findAll();
        return employmentStatusEntityList.stream().map(EmploymentStatusTransformer::entityToModel).toList();
    }
    public List<MaritalStatusModel> getMaritalStatusList(){
        List<MaritalStatus> martialStatusntityList = maritalStatusRepository.findAll();
        return martialStatusntityList.stream().map(MaritalStatusTransformer::entityToModel).toList();
    }
    public List<ProfessionModel> getProfessionsList(){
        List<Profession> professionEntityList = professionRepository.findAll();
        return professionEntityList.stream().map(ProfessionTransformer::entityToModel).toList();
    }
    public List<TitleModel> getTitlesList(){
        List<Title> titleEntityList = titleRepository.findAll();
        return titleEntityList.stream().map(TitleTransformer::entityToModel).toList();
    }
    public List<YearlyIncomeModel> getYearlyIncomesList(){
        List<YearlyIncome> yearlyIncomeEntityList = yearlyIncomeRepository.findAll();
        return yearlyIncomeEntityList.stream().map(YearlyIncomeTransformer::entityToModel).toList();
    }
//    public List<UserInterfaceRuleModel> getUserInterfaceRules(){
//        List<UIFieldRules> userInterfaceEntityList = userInterfaceRulesRepository.findAll();
//        return userInterfaceEntityList.stream().map(UIFieldTransformer::entityToModel).toList();
//    }
    public List<RelationshipTypeModel> getRelationshipTypesList(){
        List<RelationshipType> relationshipTypesEntityList = relationshipTypeRepository.findAll();
        return relationshipTypesEntityList.stream().map(RelationshipTypeTransformer::entityToModel).toList();
    }
    public List<HomeOwnershipTypeModel> getHomeOwnershipTypesList(){
        List<HomeOwnershipType> homeOwnershipTypesEntityList = homeOwnershipTypeRepository.findAll();
        return homeOwnershipTypesEntityList.stream().map(HomeOwnershipTypeTransformer::entityToModel).toList();
    }

    public List<ProductModel> getProductsList(){
        List<Product> productsEntityList = productRepository.findAll();
        return productsEntityList.stream().map(ProductTransformer::entityToModel).toList();
    }

    public List<BranchModel> getBranchList(){
        List<Branch> branchEntityList = branchRepository.findAll();
        return branchEntityList.stream().map(BranchTransformer::entityToModel).toList();
    }

    public List<DocumentTypeModel> getDocumentTypesList(){
        List<DocumentType> documentTypeEntityList = documentTypeRepository.findAll();
        return documentTypeEntityList.stream().map(DocumentTransformer::entityToModel).toList();
    }



}
