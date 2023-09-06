import { createSlice } from '@reduxjs/toolkit'

const masterDataSlice = createSlice(
    {
        name: "MasterData",
        initialState: {
            requestTypesList: ["one", "two"],
            requestStageList: [],
            customerTypeList: [],
            customerStatusList: [],
            titleList: [],
            countryList: [],
            educationLevelList: [],
            employmentStatusList: [],
            maritalStatusList: [],
            professionList: [],
            yearlyIncomeList: [],
            homeOwnershipTypesList:[],
            relationshipTypesList:[],
            userInterfaceRulesList: []
        },
        reducers: {
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