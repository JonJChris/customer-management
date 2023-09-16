import React, {useState} from 'react'
import TextField from '../../elements/TextField'
import SelectField from '../../elements/SelectField'
import WorkflowRibbon from './WorkflowRibbon'
import { useSelector } from 'react-redux'
import { isFieldEditable, isFieldMandatory, isFieldVisible } from '../../utility/generalUtil'
import { postRequestAndThenCallBack} from '../../utility/api-util'
import {NEW_REQUEST_NEW_CUSTOMER, API_URL_CREATE_REQUEST} from '../../utility/constants'
import { useNavigate } from 'react-router-dom'
const stages = [
  { stageId: '1', stageName: "Collect KYC", stageStatus: "COMPLETE" },
  { stageId: '2', stageName: "Add Products", stageStatus: "COMPLETE" },
  { stageId: '3', stageName: "Update Documents", stageStatus: "INPROGRESS" },
  { stageId: '4', stageName: "Review and Submit", stageStatus: "PENDING" },
  { stageId: '5', stageName: "Approval", stageStatus: "PENDING" },
  { stageId: '6', stageName: "Closed", stageStatus: "PENDING" },

]


const CreateNewCustomerRequest = (props) => {
  const navigate = useNavigate();

  const masterData = useSelector(state => state.masterDataSlice);
  const uiFieldStore = useSelector(state => state.UIFieldStoreSlice);
  const [newCustomer, setNewCustomer] = useState({
                                            Field_210_create_new_request_first_name:'', 
                                            Field_211_create_new_request_last_name:'', 
                                            Field_212_create_new_request_nationality:''});
  const changeHandler = (evt) => {
    setNewCustomer((prevState) => {
      return {
          ...prevState,
          [evt.target.name] : evt.target.value
      }
    })
  }
  const clickHandler = (evt) => {
    const requestBody = {
      customerId:0,
      firstName: newCustomer.Field_210_create_new_request_first_name,
      lastName:newCustomer.Field_211_create_new_request_last_name,
      nationality: newCustomer.Field_212_create_new_request_nationality,
      requestType : NEW_REQUEST_NEW_CUSTOMER
    }
    console.log('click handler')
    postRequestAndThenCallBack(API_URL_CREATE_REQUEST, requestBody, newRequestCallBack);
  }

const newRequestCallBack = (response) => {
  if(response && response.requestId){
    navigate(`/request/${response.requestId}/basic`);
  }
  
}

  return (
  <div>
   
    <div className='mt-3 border border-rounded p-3'>

        <div className='row'>
        
        <div className='col-6 mx-auto'>
          <TextField fieldId="Field_210_create_new_request_first_name" fieldName="First Name" fieldValue={newCustomer.Field_210_create_new_request_first_name}
            fieldOnChange={changeHandler} isMandatory={false} isVisible={true} isEditable={true}/>
        </div>
        
        </div>
        
        <div className='row'>
        
        <div className='col-6 mx-auto'>
          <TextField fieldId="Field_211_create_new_request_last_name" fieldName="Last Name" fieldValue={newCustomer.Field_211_create_new_request_last_name}
           fieldOnChange={changeHandler} isMandatory={false} isVisible={true} isEditable={true}/>
        </div>
        
        </div>

        <div className='row'>

        <div className='col-6 mx-auto'>
          <SelectField fieldId="Field_212_create_new_request_nationality" fieldName="Nationality" fieldValue={newCustomer.Field_212_create_new_request_nationality}
            fieldOptions={masterData.countryModelList} 
            isMandatory={false} isVisible={true} isEditable={true} 
            fieldOnChange={changeHandler} 
            />
        </div>

        

        </div>
        <div className='row'>
        
        <div className='col-6 mx-auto'>
          <div className='float-end'>
          <button name='Field_213_create_new_create_button' className='btn btn-primary' onClick={clickHandler}
          disabled={
            (newCustomer.Field_210_create_new_request_first_name === '' || 
            newCustomer.Field_211_create_new_request_last_name === '' || 
            newCustomer.Field_212_create_new_request_nationality === '')
          }
          
          >Create</button>
          </div>
        </div>
        
        </div>

 
      </div>
      </div>
      
  )
}

export default CreateNewCustomerRequest