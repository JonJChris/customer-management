package com.management.customer.controller;

import com.management.customer.model.master.*;
import com.management.customer.service.MasterDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/masterData")
@CrossOrigin(origins =  {"http://localhost","http://localhost:3000"})
public class MasterDataController {
    @Autowired
    MasterDataService masterDataService;

    @GetMapping("/fetchAll")
    public MasterDataModel getMasterData(){
        return masterDataService.getMasterData();
    }
    @GetMapping("/requestType")
    public List<RequestTypeModel> getRequestTypes(){
        return masterDataService.getRequestTypeList();
    }
    @GetMapping("/country")
    public List<CountryModel> getCountryList(){
        return masterDataService.getCountryList();
    }
    @GetMapping("/customerStatus")
    public List<CustomerStatusModel> getCustomerStatusList(){
        return masterDataService.getCustomerStatusList();
    }
    @GetMapping("/customerType")
    public List<CustomerTypeModel> getCustomerTypeList(){
        return masterDataService.getCustomerTypeList();
    }
    @GetMapping("/employmentStatus")
    public List<EmploymentStatusModel> getEmploymentStatusList(){
        return masterDataService.getEmploymentStatusList();
    }
    @GetMapping("/educationLevel")
    public List<EducationLevelModel> getEducationLevelsList(){
        return masterDataService.getEducationLevelList();
    }
    @GetMapping("/maritalStatus")
    public List<MaritalStatusModel> getMaritalStatusList(){
        return masterDataService.getMaritalStatusList();
    }
    @GetMapping("/profession")
    public List<ProfessionModel> getProfessionsList(){
        return masterDataService.getProfessionsList();
    }
    @GetMapping("/Stage")
    public List<StageTypeModel> getStagesList(){
        return masterDataService.getStageTypeList();
    }
    @GetMapping("/title")
    public List<TitleModel> getTitleList(){
        return masterDataService.getTitlesList();
    }
    @GetMapping("/yearlyIncome")
    public List<YearlyIncomeModel> getYearlyIncomeList(){
        return masterDataService.getYearlyIncomesList();
    }

//    @GetMapping("/userInterfaceRule")
//    public List<UserInterfaceRuleModel> geUserInterfaceRules(){
//        return masterDataService.getUserInterfaceRules();
//    }
    @GetMapping("/relationship")
    public List<RelationshipTypeModel> getRelationshipTypesList(){
        return masterDataService.getRelationshipTypesList();
    }
    @GetMapping("/homeOwnership")
    public List<HomeOwnershipTypeModel> getHomeOwnershipTypesList(){
        return masterDataService.getHomeOwnershipTypesList();
    }
    @GetMapping("/product")
    public List<ProductModel> getProductsList(){
        return masterDataService.getProductsList();
    }
    @GetMapping("/branch")
    public List<BranchModel> getBranchList(){
        return masterDataService.getBranchList();
    }
    @GetMapping("/documentType")
    public List<DocumentTypeModel> getDocumentTypesList(){
        return masterDataService.getDocumentTypesList();
    }

}
