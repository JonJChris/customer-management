

const updateRequestType = (res, dispatchFunc, actions) => dispatchFunc(actions.refreshRequesTypesList(res[0]));
const updateCountry = (res, dispatchFunc, actions) => dispatchFunc(actions.refreshCountryList(res[0]));
const updateCustomerStatus = (res, dispatchFunc, actions) => dispatchFunc(actions.refreshCustomerStatusList(res[0]));
const updateCustomerType = (res, dispatchFunc, actions) => dispatchFunc(actions.refreshCustomertypeList(res[0]));
const updateEmploymentStatus = (res, dispatchFunc, actions) => dispatchFunc(actions.refreshEmploymentStatusList(res[0]));
const updateEducationLevel = (res, dispatchFunc, actions) => dispatchFunc(actions.refreshEducationLevelList(res[0]));
const updateMartialStatus = (res, dispatchFunc, actions) => dispatchFunc(actions.refreshMartialStatusList(res[0]));
const updateProfession = (res, dispatchFunc, actions) => dispatchFunc(actions.refreshProfessionList(res[0]));
const updateRequestStage = (res, dispatchFunc, actions) => dispatchFunc(actions.refreshRequestStageList(res[0]));
const updateTitle = (res, dispatchFunc, actions) => dispatchFunc(actions.refreshTitleList(res[0]));
const updateYearlyIncome = (res, dispatchFunc, actions) => dispatchFunc(actions.refreshYearlyIncomeList(res[0]));
const updateUserInterativeRules = (res, dispatchFunc, actions) => dispatchFunc(actions.refreshUserInterfaceRulesList(res[0]));
const updateRelationshipType = (res, dispatchFunc, actions) => dispatchFunc(actions.refreshRelationshipTypesList(res[0]));
const updateHomeOwnershipType = (res, dispatchFunc, actions) => dispatchFunc(actions.refreshHomeOwnershipTypsList(res[0]));

const fetchMasterData = async (url, callbackFunc, dispatch, actions) => {
    try {
      const response = await fetch(url);
      if (!response.ok) {
        throw new Error("Invalid Repsone");
      }
      const reqTypes = await response.json();
      callbackFunc([reqTypes, null], dispatch, actions);
    } catch (error) {
      callbackFunc([null, "Request Failed for " + url + ", " + error]);
    }
  }

export const loadMasterData = (dispatch, actions) => {
    fetchMasterData('http://localhost:8080/masterData/requestType', updateRequestType);
    fetchMasterData('http://localhost:8080/masterData/country', updateCountry);
    fetchMasterData('http://localhost:8080/masterData/customerStatus', updateCustomerStatus);
    fetchMasterData('http://localhost:8080/masterData/customerType', updateCustomerType);
    fetchMasterData('http://localhost:8080/masterData/relationship', updateRelationshipType);
    fetchMasterData('http://localhost:8080/masterData/homeOwnership', updateHomeOwnershipType);
    fetchMasterData('http://localhost:8080/masterData/employmentStatus', updateEmploymentStatus);
    fetchMasterData('http://localhost:8080/masterData/educationLevel', updateEducationLevel);
    fetchMasterData('http://localhost:8080/masterData/maritalStatus', updateMartialStatus);
    fetchMasterData('http://localhost:8080/masterData/profession', updateProfession);
    fetchMasterData('http://localhost:8080/masterData/requestStage', updateRequestStage);
    fetchMasterData('http://localhost:8080/masterData/title', updateTitle);
    fetchMasterData('http://localhost:8080/masterData/yearlyIncome', updateYearlyIncome);
    fetchMasterData('http://localhost:8080/masterData/userInterfaceRule', updateUserInterativeRules);
    dispatch(actions.updateMasterDataExistsFlag(true));
}
