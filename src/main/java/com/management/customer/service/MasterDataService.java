package com.management.customer.service;

import com.management.customer.model.master.*;
import com.management.customer.entity.master.*;
import com.management.customer.repository.master.*;
import com.management.customer.repository.workflow.UserInterfaceRulesRepository;
import com.management.customer.tranformer.master.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MasterDataService {
    @Autowired
    RequestTypeRepository requestTypeRepository;
    @Autowired
    StageTypeRepository stageTypeRepository;
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
                getEmploymentStatusList(), getMaritalStatusList(), getProfessionsList(), getStageTypeList(), getTitlesList(), getYearlyIncomesList(),
                getRelationshipTypesList(), getHomeOwnershipTypesList(), getProductsList(), getBranchList(), getDocumentTypesList());

    }
    public List<RequestTypeModel> getRequestTypeList(){
        List<RequestType> requestTypesEntityList = requestTypeRepository.findAll();
        return requestTypesEntityList.stream().map(RequestTypeTransformer::entityToModel).toList();
    }
    public List<StageTypeModel> getStageTypeList(){
        List<StageType> requestTypesEntityList = stageTypeRepository.findAll();
        return requestTypesEntityList.stream().map(StageTypeTransformer::entityToModel).toList();
    }
//    public List<StageTypeModel> getRequestStageList(){
//        List<StageType> stageTypeEntityList = stageTypeRepository.findAll();
//        return stageTypeEntityList.stream().map(StageTypeTransformer::entityToModel).toList();
//    }
    public List<CountryModel> getCountryList(){
        List<CountryType> countryTypeEntityList = countryRepository.findAll();
        return countryTypeEntityList.stream().map(CountryTypeTransformer::entityToModel).toList();
    }

    public List<CustomerStatusModel> getCustomerStatusList(){
        List<CustomerStatusType> customerStatusTypeEntityList = customerStatusRepository.findAll();
        return customerStatusTypeEntityList.stream().map(CustomerStatusTypeTransformer::entityToModel).toList();
    }
    public List<CustomerTypeModel> getCustomerTypeList(){
        List<CustomerType> customerTypeEntityList = customerTypeRepository.findAll();
        return customerTypeEntityList.stream().map(CustomerTypeTransformer::entityToModel).toList();
    }

    public List<EducationLevelModel> getEducationLevelList(){
        List<EducationLevelType> educationLevelTypeREntityList = educationLevelRepository.findAll();
        return educationLevelTypeREntityList.stream().map(EducationLevelTypeTransformer::entityToModel).toList();
    }
    public List<EmploymentStatusModel> getEmploymentStatusList(){
        List<EmploymentStatusType> employmentStatusTypeEntityList = employmentStatusRepository.findAll();
        return employmentStatusTypeEntityList.stream().map(EmploymentStatusTypeTransformer::entityToModel).toList();
    }
    public List<MaritalStatusModel> getMaritalStatusList(){
        List<MaritalStatusType> martialStatusntityList = maritalStatusRepository.findAll();
        return martialStatusntityList.stream().map(MaritalStatusTypeTransformer::entityToModel).toList();
    }
    public List<ProfessionModel> getProfessionsList(){
        List<ProfessionType> professionTypeEntityList = professionRepository.findAll();
        return professionTypeEntityList.stream().map(ProfessionTypeTransformer::entityToModel).toList();
    }
    public List<TitleModel> getTitlesList(){
        List<TitleType> titleTypeEntityList = titleRepository.findAll();
        return titleTypeEntityList.stream().map(TitleTypeTransformer::entityToModel).toList();
    }
    public List<YearlyIncomeModel> getYearlyIncomesList(){
        List<YearlyIncomeType> yearlyIncomeEntityList = yearlyIncomeRepository.findAll();
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
        List<ProductType> productsEntityList = productRepository.findAll();
        return productsEntityList.stream().map(ProductTypeTransformer::entityToModel).toList();
    }

    public List<BranchModel> getBranchList(){
        List<BranchType> branchEntityList = branchRepository.findAll();
        return branchEntityList.stream().map(BranchTypeTransformer::entityToModel).toList();
    }

    public List<DocumentTypeModel> getDocumentTypesList(){
        List<DocumentType> documentTypeEntityList = documentTypeRepository.findAll();
        return documentTypeEntityList.stream().map(DocumentTypeTransformer::entityToModel).toList();
    }

    public Optional<CustomerType> getCustomerTypeEntity(CustomerTypeModel customerTypeModel){
        return customerTypeRepository.findById(customerTypeModel.customerTypeId());
    }
    public Optional<CountryType> getCountryEntity(CountryModel countryModel){
        return countryRepository.findById(countryModel.countryId());
    }
    public Optional<CustomerStatusType> getCustomerStatusEntity(CustomerStatusModel customerStatusModel){
        return customerStatusRepository.findById(customerStatusModel.customerStatusId());
    }
    public Optional<DocumentType> getDocumentTypeEntity(DocumentTypeModel documentTypeModel){
        return documentTypeRepository.findById(documentTypeModel.documentTypeId());
    }
    public Optional<EducationLevelType> getEducationLevelEntity(EducationLevelModel educationLevelModel){
        return educationLevelRepository.findById(educationLevelModel.educationLevelId());
    }
    public Optional<EmploymentStatusType> getEmploymentStatusEntity(EmploymentStatusModel employmentStatusModel){
        return employmentStatusRepository.findById(employmentStatusModel.employmentStatusId());
    }
    public Optional<HomeOwnershipType> getHomeOwnershipTypeEntity(HomeOwnershipTypeModel homeOwnershipTypeModel){
        return homeOwnershipTypeRepository.findById(homeOwnershipTypeModel.homeOwnershipTypeId());
    }
    public Optional<MaritalStatusType> getMartialStatusEntity(MaritalStatusModel maritalStatusModel){
        return maritalStatusRepository.findById(maritalStatusModel.maritalStatusId());
    }
    public Optional<ProductType> getProductEntity(ProductModel productModel){
        return productRepository.findById(productModel.productTypeId());
    }

    public Optional<BranchType> getBranchEntity(BranchModel branchModel){
        return branchRepository.findById(branchModel.branchTypeId());
    }

    public Optional<ProfessionType> getProfessionEntity(ProfessionModel professionModel){
        return professionRepository.findById(professionModel.professionId());
    }
    public Optional<RelationshipType> getRelationshipTypeEntity(RelationshipTypeModel relationshipTypeModel){
        return relationshipTypeRepository.findById(relationshipTypeModel.relationshipTypeId());
    }
    public Optional<StageType> getStageEntity(StageTypeModel stageTypeModel){
        return stageTypeRepository.findById(stageTypeModel.stageId());
    }
    public Optional<RequestType> getRequestTypeEntity(RequestTypeModel requestTypeModel){
        return requestTypeRepository.findById(requestTypeModel.requestTypeId());
    }
    public Optional<TitleType> getTitleEntity(TitleModel titleModel){
        return titleRepository.findById(titleModel.titleId());
    }
    public Optional<YearlyIncomeType> getYearlyIncomeEntity(YearlyIncomeModel yearlyIncomeModel){
        return yearlyIncomeRepository.findById(yearlyIncomeModel.yearlyIncomeId());
    }


}
