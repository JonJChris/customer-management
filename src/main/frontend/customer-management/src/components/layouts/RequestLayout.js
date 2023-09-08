import React, { useEffect, useState } from 'react'
import RequestHead from '../contents/RequestHead'
import TopNavigation from '../TopNavigation'
import RequestButtons from '../contents/RequestButtons'
import RequestTabs from './../layouts/RequestTabs'
import { Outlet, useParams } from 'react-router-dom'
import { useDispatch, useSelector } from 'react-redux'
import { actions } from './../../store/master-data'
import { actions as uiFieldActions } from './../../store/ui-field-store'
import { updateRequestHeadDetails, updateAdditionalDetails, updateAddressDetails, updateBasicDetails, buildRequestBody } from '../utility/data-util'
import {putRequestAndThenCallBack, getRequestAndThenCallBack } from './../utility/api-util'

const RequestLayout = () => {
  const tabItems = [
    { tabId: '137_basic_details_tab', tabName: "Basic Details", tabErrors: 0, isActive: true, tabLink: './basic' },
    { tabId: '138_address_details_tab', tabName: "Address Details", tabErrors: 0, isActive: false, tabLink: 'Address' },
    { tabId: '139_additional_details_tab', tabName: "Additional Details", tabErrors: 0, isActive: false, tabLink: 'Additional' },
    { tabId: '140_product_details_tab', tabName: "Product Details", tabErrors: 0, isActive: false, tabLink: 'Product' },
    { tabId: '141_document_details_tab', tabName: "Document Details", tabErrors: 0, isActive: false, tabLink: 'Document' },
  ]
  const dispatch = useDispatch();
  const masterData = useSelector(state => state.masterDataSlice);
  const userStore = useSelector(state => state.UserStoreSlice);
  const params = useParams();
  const [requestHeadDetails, setRequestHeadDetails] = useState({ Field_100_request_id: 0, Field_102_request_type: { key: 0, value: '' }, Field_101_request_created: "", Field_103_request_status: {key: 0, value: ''} })
  const [basicDetails, setBasicDetails] = useState({
    Field_104_customer_id: 0, Field_105_customer_title: { key: 0, value: '' }, Field_106_customer_first_name: '', Field_107_customer_last_name: '', 
    Field_108_customer_display_name: '', Field_109_customer_nationality: { key: 0, value: '' }, Field_144_customer_email: '', Field_110_customer_date_of_birth: '', 
    Field_112_customer_marital_status: { key: 0, value: '' }, Field_113_customer_type: {}
  })
  const [addressDetails, setAddressDetails] = useState({ 
    addressId: 0, Field_114_reg_address_line1: "", Field_115_reg_address_line2: "", Field_116_reg_address_city: "", 
    Field_117_reg_address_state: "", Field_118_reg_address_country: { key: 0, value: '' }, Field_119_reg_address_postal_code: "", 
    Field_120_com_address_line1: "", Field_121_com_address_line2: "", Field_122_com_address_city: "", Field_123_com_address_state: "", 
    Field_124_com_address_country: { key: 0, value: '' }, Field_125_com_address_postal_code: "" })

  const [additionalDetails, setAdditionalDetails] = useState({ 
    Field_126_educational_qualification: { key: 0, value: '' }, Field_127_occupation_type: { key: 0, value: '' }, 
    Field_128_organisation_name: "", Field_130_yearly_income: "", Field_142_home_ownership_type: { key: 0, value: '' }, 
    Field_132_nominee_relationship_type: { key: 0, value: '' }, Field_133_nominee_first_name: "", Field_134_nominee_last_name: "", 
    Field_143_nominee_date_of_birth: "" })
  const [tabState, setTabState] = useState({
    tabs: [

    ]
  });


  // const fetchAndThenCallBack = async (url, callbackFunc) => {
  //   try {
  //     const resp = await fetch(url);
  //     if (!resp.ok) {
  //       throw new Error("Error while fetching from url " + url)
  //     }
  //     const data = await resp.json();
  //     callbackFunc(data);
  //   } catch (error) {
  //     console.log(error.message);
  //   }
  // }

  const updateMasterDataInStore = (masterData) => {
    dispatch(actions.refreshMasterData(masterData));
  }
  const updateRequestPageState = (requestDetails) => {
    updateRequestHeadDetails(requestDetails, setRequestHeadDetails);
    updateBasicDetails(requestDetails, setBasicDetails);
    updateAddressDetails(requestDetails, setAddressDetails);
    updateAdditionalDetails(requestDetails, setAdditionalDetails);
    dispatch(uiFieldActions.updateUIFields(requestDetails.uiInputFieldModelsList));
    dispatch(uiFieldActions.updateUITabs(requestDetails.uiTabModelsList));
  }


  useEffect(() => {
    if (!masterData.masterDataExists) {
      getRequestAndThenCallBack('http://localhost:8080/api/masterData/fetchAll', updateMasterDataInStore);
    }

    if (params.requestId) {
      getRequestAndThenCallBack(`http://localhost:8080/api/request/${params.requestId}`, updateRequestPageState);
    }

  }, []);

  const updateStateDetailsTab = (evt, setStateFunc)=> {
    let newVal = ''
    if(evt.target.type === 'select-one'){
      newVal = {key: evt.target.value, value: evt.target.options[evt.target.selectedIndex].text}
    }else{
      newVal = evt.target.value;
    }
    setStateFunc((prevState) => {
      return {
        ...prevState,
        [evt.target.name]: newVal
      }
    })
  }


  const updateStateForBasicDetailTab = (evt) => updateStateDetailsTab(evt, setBasicDetails);
  const updateStateForAddressTab = (evt) => updateStateDetailsTab(evt, setAddressDetails);
  const updateStateForAdditionalTab = (evt) => updateStateDetailsTab(evt, setAdditionalDetails);
  

  const submitRequest = (evt) => {
    evt.preventDefault();
    // console.log("**** "+JSON.stringify(userStore.userDetails));
    const requestBody = buildRequestBody(requestHeadDetails, basicDetails, addressDetails, additionalDetails, userStore.userDetails);
    putRequestAndThenCallBack(`http://localhost:8080/api/request/${params.requestId}`, requestBody ,updateRequestPageState);
  }

  return (
    <div>

      <TopNavigation />
      <form onSubmit={submitRequest}>
        <RequestHead {...requestHeadDetails} />

        <div className='border border-rounded mt-2 p-2'>
          <RequestTabs tabItems={tabItems} />
          <div className="tab-content" id="myTabContent">
            <Outlet context={ {basicDetails, addressDetails, additionalDetails, updateStateForBasicDetailTab, updateStateForAddressTab, updateStateForAdditionalTab }} />
          </div>
        </div>

        <RequestButtons fieldOnSubmit={submitRequest} />
      </form>
    </div>
  )

  }

export default RequestLayout



