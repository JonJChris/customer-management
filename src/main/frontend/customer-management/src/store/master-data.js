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
            productModelList:[],
            branchModelList:[]
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
                    state.productModelList = masterData.productModelList && masterData.productModelList.map( item => ({optionKey:item.productTypeId, optionValue:item.productTypeName}));
                    state.branchModelList = masterData.branchModelList && masterData.branchModelList.map( item => ({optionKey:item.branchTypeId, optionValue:item.branchTypeName}));
                    state.documentTypeModelList = masterData.documentTypeModelList && masterData.documentTypeModelList.map( item => ({optionKey:item.documentTypeId, optionValue:item.documentTypeName}));
                    
                    state.masterDataExists = true;
                }
            },
            updateMasterDataExistsFlag: (state, action) => {
                state.masterDataExists = action.payload;
            },
            refreshRequestTypeModelList: (state, action) => {
                state.requestTypeModelList = action.payload && action.payload.map( item => ({optionKey:item.requestTypeId, optionValue:item.requestTypeName}));
            },
            refreshRequestStageModelList: (state, action) => {
                state.requestStageModelList =  action.payload && action.payload.map( item => ({optionKey:item.requestStageId, optionValue:item.requestStageName}));
            },
            refreshCustomerTypeModelList: (state, action) => {
                state.customerTypeModelList =  action.payload && action.payload.map( item => ({optionKey:item.customerTypeId, optionValue:item.customerTypeName}));
            },
            refreshCustomerStatusList: (state, action) => {
                state.customerStatusList = action.payload && action.payload.map( item => ({optionKey:item.customerStatusId, optionValue:item.customerStatusName}));
            },
            refreshCountryModelList: (state, action) => {
                state.countryModelList =  action.payload && action.payload.map( item => ({optionKey:item.countryId, optionValue:item.countryName}));
            },
            refreshEducationLevelsList: (state, action) => {
                state.educationLevelsList =  action.payload && action.payload.map( item => ({optionKey:item.educationLevelId, optionValue:item.educationLevelName}));
            },
            refreshEmploymentStatusModelList: (state, action) => {
                state.employmentStatusModelList =  action.payload && action.payload.map( item => ({optionKey:item.employmentStatusId, optionValue:item.employmentStatusName}));
            },
            refreshMaritalStatusModelList: (state, action) => {
                state.maritalStatusModelList =  action.payload && action.payload.map( item => ({optionKey:item.maritalStatusId, optionValue:item.maritalStatusName}));
            },
            refreshProfessionModelList: (state, action) => {
                state.professionModelList =  action.payload && action.payload.map( item => ({optionKey:item.professionId, optionValue:item.professionName}));
            },
            refreshYearlyIncomeModelList: (state, action) => {
                state.yearlyIncomeModelList =  action.payload && action.payload.map( item => ({optionKey:item.yearlyIncomeId, optionValue:item.yearlyIncomeName}));
            },
            refreshTitleModelList: (state, action) => {
                state.titleModelList =  action.payload && action.payload.map( item => ({optionKey:item.titleId, optionValue:item.titleName}));
            },
            refreshHomeOwnershipTypeModelList: (state, action) => {
                state.homeOwnershipTypeModelList =  action.payload && action.payload.map( item => ({optionKey:item.homeOwnershipTypeId, optionValue:item.homeOwnershipTypeName}));
            },
            refreshRelationshipTypeModelList: (state, action) => {
                state.relationshipTypeModelList =  action.payload && action.payload.map( item => ({optionKey:item.relationshipTypeId, optionValue:item.relationshipTypeName}));
            },
     
        }
    }
)

export const actions = masterDataSlice.actions;
export default masterDataSlice;