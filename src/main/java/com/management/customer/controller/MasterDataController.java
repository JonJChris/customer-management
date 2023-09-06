package com.management.customer.controller;

import com.management.customer.dto.*;
import com.management.customer.service.MasterDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/masterData")
@CrossOrigin(origins =  {"http://localhost","http://localhost:3000"})
public class MasterDataController {
    @Autowired
    MasterDataService masterDataService;
    @GetMapping("/requestType")
    public List<RequestTypeDTO> getRequestTypes(){
        return masterDataService.getRequestTypeList();
    }
    @GetMapping("/country")
    public List<CountryDTO> getCountryList(){
        return masterDataService.getCountryList();
    }
    @GetMapping("/customerStatus")
    public List<CustomerStatusDTO> getCustomerStatusList(){
        return masterDataService.getCustomerStatusList();
    }
    @GetMapping("/customerType")
    public List<CustomerTypeDTO> getCustomerTypeList(){
        return masterDataService.getCustomerTypeList();
    }
    @GetMapping("/employmentStatus")
    public List<EmploymentStatusDTO> getEmploymentStatusList(){
        return masterDataService.getEmploymentStatusList();
    }
    @GetMapping("/educationLevel")
    public List<EducationLevelDTO> getEducationLevelsList(){
        return masterDataService.getEducationLevelList();
    }
    @GetMapping("/maritalStatus")
    public List<MaritalStatusDTO> getMaritalStatusList(){
        return masterDataService.getMaritalStatusList();
    }
    @GetMapping("/profession")
    public List<ProfessionDTO> getProfessionsList(){
        return masterDataService.getProfessionsList();
    }
    @GetMapping("/requestStage")
    public List<RequestStageDTO> getRequestStagesList(){
        return masterDataService.getRequestStageList();
    }
    @GetMapping("/title")
    public List<TitleDTO> getTitleList(){
        return masterDataService.getTitlesList();
    }
    @GetMapping("/yearlyIncome")
    public List<YearlyIncomeDTO> getYearlyIncomeList(){
        return masterDataService.getYearlyIncomesList();
    }

    @GetMapping("/userInterfaceRule")
    public List<UserInterfaceRuleDTO> geUserInterfaceRules(){
        return masterDataService.getUserInterfaceRules();
    }
    @GetMapping("/relationship")
    public List<RelationshipTypeDTO> getRelationshipTypesList(){
        return masterDataService.getRelationshipTypesList();
    }
    @GetMapping("/homeOwnership")
    public List<HomeOwnershipTypeDTO> getHomeOwnershipTypesList(){
        return masterDataService.getHomeOwnershipTypesList();
    }

}
