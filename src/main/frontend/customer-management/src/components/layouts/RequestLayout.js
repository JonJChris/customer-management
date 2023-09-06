import React, { useEffect } from 'react'
import RequestHead from '../contents/RequestHead'
import TopNavigation from '../TopNavigation'
import RequestButtons from '../contents/RequestButtons'
import RequestTabs from './../layouts/RequestTabs'
import { Outlet } from 'react-router-dom'
import {useDispatch} from 'react-redux'
import {actions} from './../../store/master-data'



const RequestLayout = () => {
  const tabItems = [
    { tabId: '137_basic_details_tab', tabName: "Basic Details", tabErrors: 0, isActive: true, tabLink: '/' },
    { tabId: '138_address_details_tab', tabName: "Address Details", tabErrors: 0, isActive: false, tabLink: 'Address' },
    { tabId: '139_additional_details_tab', tabName: "Additional Details", tabErrors: 0, isActive: false, tabLink: 'Additional' },
    { tabId: '140_product_details_tab', tabName: "Product Details", tabErrors: 0, isActive: false, tabLink: 'Product' },
    { tabId: '141_document_details_tab', tabName: "Document Details", tabErrors: 0, isActive: false, tabLink: 'Document' },
  ]

  const dispatch = useDispatch();

  const fetchMasterData = async (url, callbackFunc) => {
       try {
      const response = await fetch(url);
      if (!response.ok) {
        throw new Error("Invalid Repsone");
      }
      const reqTypes = await response.json();
      callbackFunc([reqTypes, null]);
    } catch (error) {
      callbackFunc([null, "Request Failed for "+ url +", "+error]);
    }
  }

  const updateRequestType = (res) => dispatch(actions.refreshRequesTypesList(res[0]));
  const updateCountry = (res) => dispatch(actions.refreshCountryList(res[0]));
  const updateCustomerStatus = (res) => dispatch(actions.refreshCustomerStatusList(res[0]));
  const updateCustomerType = (res) => dispatch(actions.refreshCustomertypeList(res[0]));
  const updateEmploymentStatus = (res) => dispatch(actions.refreshEmploymentStatusList(res[0]));
  const updateEducationLevel = (res) => dispatch(actions.refreshEducationLevelList(res[0]));
  const updateMartialStatus = (res) => dispatch(actions.refreshMartialStatusList(res[0]));
  const updateProfession = (res) => dispatch(actions.refreshProfessionList(res[0]));
  const updateRequestStage = (res) => dispatch(actions.refreshRequestStageList(res[0]));
  const updateTitle = (res) => dispatch(actions.refreshTitleList(res[0]));
  const updateYearlyIncome = (res) => dispatch(actions.refreshYearlyIncomeList(res[0]));
  const updateUserInterativeRules = (res) => dispatch(actions.refreshUserInterfaceRulesList(res[0]));
  const updateRelationshipType = (res) => dispatch(actions.refreshRelationshipTypesList(res[0]));
  const updateHomeOwnershipType = (res) => dispatch(actions.refreshHomeOwnershipTypsList(res[0]));

    useEffect(() => {

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
      

    }, []);



  return (
    <div>

      <TopNavigation />
      <RequestHead />

      <div className='border border-rounded mt-2 p-2'>
        <RequestTabs tabItems={tabItems} />
        <div className="tab-content" id="myTabContent">
          <Outlet />
        </div>
      </div>

      <RequestButtons />
    </div>
  )
}


export default RequestLayout


