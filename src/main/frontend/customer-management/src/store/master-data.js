import { createSlice } from '@reduxjs/toolkit'

const masterDataSlice = createSlice(
    {
        name: "MasterData",
        initialState: {
            masterDataExists:false,
            requestTypeModelList: ["one", "two"],
            countryModelList: [],
            educationLevelsList: [],
            employmentStatusModelList: [],
            maritalStatusModelList: [],
            professionModelList: [],
            requestStageModelList: [],
            titleModelList: [],
            yearlyIncomeModelList: [],
            relationshipTypeModelList: [],
            homeOwnershipTypeModelList: [],
            customerTypeModelList:[],
        },
        reducers: {

            refreshMasterData : (state, action) => {
                if(action.payload){
                    const masterData = action.payload;
                    state.requestTypeModelList = masterData.requestTypeModelList && masterData.requestTypeModelList.map( item => ({optionKey:item.requestTypeId, optionValue:item.requestTypeName}));
                    state.countryModelList = masterData.countryModelList && masterData.countryModelList.map( item => ({optionKey:item.countryId, optionValue:item.countryName}));
                    state.educationLevelsList = masterData.educationLevelsList && masterData.educationLevelsList.map( item => ({optionKey:item.educationLevelId, optionValue:item.educationLevelName}));
                    state.employmentStatusModelList = masterData.employmentStatusModelList && masterData.employmentStatusModelList.map( item => ({optionKey:item.employmentStatusId, optionValue:item.employmentStatusName}));
                    state.maritalStatusModelList = masterData.maritalStatusModelList && masterData.maritalStatusModelList.map( item => ({optionKey:item.maritalStatusId, optionValue:item.maritalStatusName}));
                    state.professionModelList = masterData.professionModelList && masterData.professionModelList.map( item => ({optionKey:item.professionId, optionValue:item.professionName}));
                    state.requestStageModelList = masterData.requestStageModelList && masterData.requestStageModelList.map( item => ({optionKey:item.requestStageId, optionValue:item.requestStageName}));
                    state.titleModelList = masterData.titleModelList && masterData.titleModelList.map( item => ({optionKey:item.titleId, optionValue:item.titleName}));
                    state.yearlyIncomeModelList = masterData.yearlyIncomeModelList && masterData.yearlyIncomeModelList.map( item => ({optionKey:item.yearlyIncomeId, optionValue:item.yearlyIncomeName}));
                    state.relationshipTypeModelList = masterData.relationshipTypeModelList && masterData.relationshipTypeModelList.map( item => ({optionKey:item.relationshipTypeId, optionValue:item.relationshipTypeName}));
                    state.homeOwnershipTypeModelList = masterData.homeOwnershipTypeModelList && masterData.homeOwnershipTypeModelList.map( item => ({optionKey:item.homeOwnershipTypeId, optionValue:item.homeOwnershipTypeName}));
                    state.customerTypeModelList = masterData.customerTypeModelList && masterData.customerTypeModelList.map( item => ({optionKey:item.customerTypeId, optionValue:item.customerTypeName}));
                    state.masterDataExists = true;
                }
            },
            updateMasterDataExistsFlag: (state, action) => {
                state.masterDataExists = action.payload;
            },
            refreshRequesTypesList: (state, action) => {
                state.requestTypesList = action.payload && action.payload.map( item => ({optionKey:item.requestTypeId, optionValue:item.requestTypeName}));
            },
            refreshRequestStageList: (state, action) => {
                state.requestStageList =  action.payload && action.payload.map( item => ({optionKey:item.requestStageId, optionValue:item.requestStageName}));
            },
            refreshCustomertypeList: (state, action) => {
                state.customerTypeList =  action.payload && action.payload.map( item => ({optionKey:item.customerTypeId, optionValue:item.customerTypeName}));
            },
            refreshCustomerStatusList: (state, action) => {
                state.customerStatusList = action.payload && action.payload.map( item => ({optionKey:item.customerStatusId, optionValue:item.customerStatusName}));
            },
            refreshCountryList: (state, action) => {
                state.countryList =  action.payload && action.payload.map( item => ({optionKey:item.countryId, optionValue:item.countryName}));
            },
            refreshEducationLevelList: (state, action) => {
                state.educationLevelList =  action.payload && action.payload.map( item => ({optionKey:item.educationLevelId, optionValue:item.educationLevelName}));
            },
            refreshEmploymentStatusList: (state, action) => {
                state.employmentStatusList =  action.payload && action.payload.map( item => ({optionKey:item.employmentStatusId, optionValue:item.employmentStatusName}));
            },
            refreshMartialStatusList: (state, action) => {
                state.maritalStatusList =  action.payload && action.payload.map( item => ({optionKey:item.maritalStatusId, optionValue:item.maritalStatusName}));
            },
            refreshProfessionList: (state, action) => {
                state.professionList =  action.payload && action.payload.map( item => ({optionKey:item.professionId, optionValue:item.professionName}));
            },
            refreshYearlyIncomeList: (state, action) => {
                state.yearlyIncomeList =  action.payload && action.payload.map( item => ({optionKey:item.yearlyIncomeId, optionValue:item.yearlyIncomeName}));
            },
            refreshTitleList: (state, action) => {
                state.titleList =  action.payload && action.payload.map( item => ({optionKey:item.titleId, optionValue:item.titleName}));
            },
             refreshHomeOwnershipTypsList: (state, action) => {
                state.homeOwnershipTypesList =  action.payload && action.payload.map( item => ({optionKey:item.homeOwnershipTypeId, optionValue:item.homeOwnershipTypeName}));
            },
             refreshRelationshipTypesList: (state, action) => {
                state.relationshipTypesList =  action.payload && action.payload.map( item => ({optionKey:item.relationshipTypeId, optionValue:item.relationshipTypeName}));
            },
            refreshUserInterfaceRulesList: (state, action) => {
                state.userInterfaceRulesList = action.payload;
            },
        }
    }
)

export const actions = masterDataSlice.actions;
export default masterDataSlice;