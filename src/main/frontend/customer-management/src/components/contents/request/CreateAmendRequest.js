import React, {useEffect, useState} from 'react'
import TextField from '../../elements/TextField'
import SelectField from '../../elements/SelectField'
import WorkflowRibbon from './WorkflowRibbon'
import { useSelector } from 'react-redux'
import { isFieldEditable, isFieldMandatory, isFieldVisible } from '../../utility/generalUtil'
import { postRequestAndThenCallBack} from '../../utility/api-util'
import {NEW_REQUEST_NEW_CUSTOMER, API_URL_CREATE_REQUEST, getRequestURL} from '../../utility/constants'
import { useLocation, useNavigate } from 'react-router-dom'


const CreateAmendRequest = (props) => {
  const location = useLocation();
  const navigate = useNavigate();

  const masterData = useSelector(state => state.masterDataSlice);
  const uiFieldStore = useSelector(state => state.UIFieldStoreSlice);
  const UserStore = useSelector(state => state.UserStoreSlice);
  const [amendCustomer, setAmendCustomer] = useState({
    Field_219_create_amend_request_customer_id:'', 
    Field_214_create_amend_request_first_name:'', 
    Field_215_create_amend_request_last_name:'',
    Field_217_create_amend_request_select_request_type: {key:'', value:''}});

    const changeHandler = (evt) => {
   
      if (evt.target.type === 'select-one') {
        setAmendCustomer((prevState) => {
              return {
                  ...prevState,
                  [evt.target.name]: {
                      key: evt.target.value,
                      value: evt.target.options[evt.target.selectedIndex].text
                  }
              }
          })
      }else{
        setAmendCustomer((prevState) => {
              return {
                  ...prevState,
                  [evt.target.name]: evt.target.value,
              }
          }) 
      }

  }

 useEffect(() => {
  setAmendCustomer((prev) => {
    return {
      ...prev,
      Field_219_create_amend_request_customer_id: location.state && location.state.customerId,
      Field_214_create_amend_request_first_name: location.state && location.state.customerFirstName,
      Field_215_create_amend_request_last_name: location.state && location.state.customerLastName 
    }
  })

 },[]);

  const clickHandler = (evt) => {
    const requestBody = {
      customerId: amendCustomer.Field_219_create_amend_request_customer_id,
      firstName: amendCustomer.Field_214_create_amend_request_first_name,
      lastName:amendCustomer.Field_215_create_amend_request_last_name,
      requestType : amendCustomer.Field_217_create_amend_request_select_request_type && amendCustomer.Field_217_create_amend_request_select_request_type.value, 
      requestSubmittedBy: UserStore.userDetails&& UserStore.userDetails.userId
    }
    const requestURL = `${getRequestURL()}/request/new`
    postRequestAndThenCallBack(requestURL, requestBody, newRequestCallBack);
  }

  const newRequestCallBack = (response) => {

    if(response && response.requestId){
      navigate(`/request/${response.requestId}`);
    }
    
  }

  return (
  <div>
   
    <div className='mt-3 border border-rounded p-3'>

        <div className='row'>
        
        <div className='col-6 mx-auto'>
          <TextField fieldId="Field_219_create_amend_request_customer_id" fieldName="Customer Id" fieldValue={amendCustomer.Field_219_create_amend_request_customer_id}
            fieldOnChange={changeHandler} isMandatory={false} isVisible={true} isEditable={false}/>
        </div>
        
        </div>
        <div className='row'>
        
        <div className='col-6 mx-auto'>
          <TextField fieldId="Field_214_create_amend_request_first_name" fieldName="First Name" fieldValue={amendCustomer.Field_214_create_amend_request_first_name}
            fieldOnChange={changeHandler} isMandatory={false} isVisible={true} isEditable={false}/>
        </div>
        
        </div>
        
        <div className='row'>
        
        <div className='col-6 mx-auto'>
          <TextField fieldId="Field_215_create_amend_request_last_name" fieldName="Last Name" fieldValue={amendCustomer.Field_215_create_amend_request_last_name}
           fieldOnChange={changeHandler} isMandatory={false} isVisible={true} isEditable={false}/>
        </div>
        
        </div>
        <div className='row'>
        
        <div className='col-6 mx-auto'>
          <SelectField fieldId="Field_217_create_amend_request_select_request_type" fieldName="Request Type" fieldValue={amendCustomer.Field_217_create_amend_request_select_request_type.key}
          fieldOptions={masterData.requestTypeModelList.filter(item => item.optionValue !== 'Create New Customer' && item.optionValue !== 'Customer Lifecycle Request')}
           fieldOnChange={changeHandler} isMandatory={false} isVisible={true} isEditable={true}/>
        </div>
        
        </div>
        

    
        <div className='row'>
        
        <div className='col-6 mx-auto'>
          <div className='float-end'>
          <button name='Field_218_create_amend_create_button' className='btn btn-primary' onClick={clickHandler}
          disabled={
            (amendCustomer.Field_219_create_amend_request_customer_id === '' || 
            amendCustomer.Field_217_create_amend_request_select_request_type.key === '')
          }
          
          >Create</button>
          </div>
        </div>
        
        </div>

 
      </div>
      </div>
      
  )
}

export default CreateAmendRequest