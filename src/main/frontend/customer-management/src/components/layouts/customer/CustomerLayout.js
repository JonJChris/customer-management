import React, { useEffect, useState } from 'react'
import RequestHead from '../../contents/request/RequestHead'
import TopNavigation from '../../TopNavigation'
import RequestButtons from '../../contents/request/RequestButtons'
import RequestTabs from '../request/RequestTabs'
import CustomerTabs from '../customer/CustomerTabs'
import { Outlet, useParams } from 'react-router-dom'
import { useDispatch, useSelector } from 'react-redux'
import { actions } from '../../../store/master-data'
import { actions as uiFieldActions } from '../../../store/ui-field-store'
import { updateCustomerHeadDetails, updateCustomerAdditionalDetails, updateCustomerAddressDetails, updateCustomerBasicDetails } from '../../utility/data-util'
import {putRequestAndThenCallBack, getRequestAndThenCallBack } from '../../utility/api-util'
import CustomerHead from '../../contents/customer/CustomerHead'

const CustomerLayout = () => {

  const tabItems = [
    { fieldName: 'Field_189_basic_details_tab', fieldDisplayName: "Basic Details", fieldErrors: 0, isActive: true, fieldLink: './basic' },
    { fieldName: 'Field_190_address_details_tab', fieldDisplayName: "Address Details", fieldErrors: 0, isActive: false, fieldLink: 'Address' },
    { fieldName: 'Field_191_additional_details_tab', fieldDisplayName: "Additional Details", fieldErrors: 0, isActive: false, fieldLink: 'Additional' },
    { fieldName: 'Field_192_product_details_tab', fieldDisplayName: "Product Details", fieldErrors: 0, isActive: false, fieldLink: 'Product' },
    { fieldName: 'Field_193_document_details_tab', fieldDisplayName: "Document Details", fieldErrors: 0, isActive: false, fieldLink: 'Document' },
  ]
  const dispatch = useDispatch();
  const masterData = useSelector(state => state.masterDataSlice);
  const userStore = useSelector(state => state.UserStoreSlice);
  const params = useParams();
  const [customerHeadDetails, setCustomerHeadDetails] = useState({ Field_197_customer_crated_date: '',  Field_198_customer_created_by: '', Field_199_customer_last_updated_date: '', Field_200_customer_last_updated_by: '' })
  const [basicDetails, setBasicDetails] = useState({
    Field_159_customer_id: 0, Field_160_customer_title: { key: 0, value: '' }, Field_161_customer_first_name: '', Field_162_customer_last_name: '', 
    Field_163_customer_display_name: '', Field_164_customer_nationality: { key: 0, value: '' }, Field_165_customer_date_of_birth: '', 
    Field_166_customer_marital_status: { key: 0, value: '' }, Field_167_customer_type: {}, Field_196_customer_email: ''
  })
  const [addressDetails, setAddressDetails] = useState({ 
    addressId: 0, Field_168_reg_address_line1: "", Field_169_reg_address_line2: "", Field_170_reg_address_city: "", 
    Field_171_reg_address_state: "", Field_172_reg_address_country: { key: 0, value: '' }, Field_173_reg_address_postal_code: "", 
    Field_174_com_address_line1: "", Field_175_com_address_line2: "", Field_176_com_address_city: "", Field_177_com_address_state: "", 
    Field_178_com_address_country: { key: 0, value: '' }, Field_179_com_address_postal_code: "" })

  const [additionalDetails, setAdditionalDetails] = useState({ 
    Field_180_educational_qualification: { key: 0, value: '' }, Field_181_occupation_type: { key: 0, value: '' }, 
    Field_182_organisation_name: "", Field_183_yearly_income: "", Field_194_home_ownership_type: { key: 0, value: '' }, 
    Field_184_nominee_relationship_type: { key: 0, value: '' }, Field_185_nominee_first_name: "", Field_186_nominee_last_name: "", 
    Field_195_nominee_date_of_birth: "" })
  const [tabState, setTabState] = useState({
    tabs: [

    ]
  });


  const updateMasterDataInStore = (masterData) => {
    dispatch(actions.refreshMasterData(masterData));
  }
  const updateCustomerPageState = (customerDetails) => {
    console.log(customerDetails)
    updateCustomerHeadDetails(customerDetails, setCustomerHeadDetails);
    updateCustomerBasicDetails(customerDetails, setBasicDetails);
    updateCustomerAddressDetails(customerDetails, setAddressDetails);
    updateCustomerAdditionalDetails(customerDetails, setAdditionalDetails);
  }


  useEffect(() => {
    if (!masterData.masterDataExists) {
      getRequestAndThenCallBack('http://localhost:8080/api/masterData/fetchAll', updateMasterDataInStore);
    }

     console.log(">> Loading Data");
    if (params.customerId) {
      getRequestAndThenCallBack(`http://localhost:8080/api/customer/${params.customerId}`, updateCustomerPageState);
    }

  }, []);

  // const updateStateDetailsTab = (evt, setStateFunc)=> {
  //   let newVal = ''
  //   if(evt.target.type === 'select-one'){
  //     newVal = {key: evt.target.value, value: evt.target.options[evt.target.selectedIndex].text}
  //   }else{
  //     newVal = evt.target.value;
  //   }
  //   setStateFunc((prevState) => {
  //     return {
  //       ...prevState,
  //       [evt.target.name]: newVal
  //     }
  //   })
  // }


  // const updateStateForBasicDetailTab = (evt) => updateStateDetailsTab(evt, setBasicDetails);
  // const updateStateForAddressTab = (evt) => updateStateDetailsTab(evt, setAddressDetails);
  // const updateStateForAdditionalTab = (evt) => updateStateDetailsTab(evt, setAdditionalDetails);
  

  // const submitRequest = (evt) => {
  //   evt.preventDefault();
  //   const requestBody = buildRequestBody(requestHeadDetails, basicDetails, addressDetails, additionalDetails, userStore.userDetails);
  //   putRequestAndThenCallBack(`http://localhost:8080/api/request/${params.requestId}`, requestBody ,updateRequestPageState);
  // }

  return (
    <div>

      <TopNavigation />
      {/* <form onSubmit={submitRequest}> */}
        <CustomerHead {...customerHeadDetails} />

        <div className='border border-rounded mt-2 p-2'>
          <CustomerTabs tabItems={tabItems} />
          <div className="tab-content" id="myTabContent">
            <Outlet context={ {basicDetails, addressDetails, additionalDetails,
              //  updateStateForBasicDetailTab, updateStateForAddressTab, updateStateForAdditionalTab 
               }} />
          </div>
        </div>

        {/* <RequestButtons fieldOnSubmit={submitRequest} /> */}
      {/* </form> */}
    </div>
  )

  }

export default CustomerLayout;


