import React from 'react'
import TextField from '../../../elements/TextField'
import SelectField from '../../../elements/SelectField'
import WorkflowRibbon from '../../request/WorkflowRibbon'
import { useSelector } from 'react-redux'
import { isFieldEditable, isFieldMandatory, isFieldVisible } from '../../../utility/generalUtil'
const stages = [
  { stageId: '1', stageName: "Collect KYC", stageStatus: "COMPLETE" },
  { stageId: '2', stageName: "Add Products", stageStatus: "COMPLETE" },
  { stageId: '3', stageName: "Update Documents", stageStatus: "INPROGRESS" },
  { stageId: '4', stageName: "Review and Submit", stageStatus: "PENDING" },
  { stageId: '5', stageName: "Approval", stageStatus: "PENDING" },
  { stageId: '6', stageName: "Closed", stageStatus: "PENDING" },

]

const RequestSearchHead = (props) => {

  const masterData = useSelector(state => state.masterDataSlice);
  const uiFieldStore = useSelector(state => state.UIFieldStoreSlice);

  return (
    <div className='mt-3 border border-rounded p-3'>
      <div className='row'>
      
        <div className='col-6 mx-auto'>
          <TextField fieldId="Field_153_search_request_id" fieldName="Request Id" fieldValue={props.Field_153_search_request_id}
           fieldOnChange={props.changeHandler}  isMandatory={false} isVisible={true} isEditable={true}/>
        </div>
      
        </div>
        <div className='row'>
        
        <div className='col-6 mx-auto'>
          <TextField fieldId="Field_154_search_customer_first_name" fieldName="Customer First Name" fieldValue={props.Field_154_search_customer_first_name}
            fieldOnChange={props.changeHandler} isMandatory={false} isVisible={true} isEditable={true}/>
        </div>
        
        </div>
        
        <div className='row'>
        
        <div className='col-6 mx-auto'>
          <TextField fieldId="Field_155_search_customer_last_name" fieldName="Customer Last Name" fieldValue={props.Field_155_search_customer_last_name}
           fieldOnChange={props.changeHandler} isMandatory={false} isVisible={true} isEditable={true}/>
        </div>
        
        </div>

        <div className='row'>

        <div className='col-6 mx-auto'>
          <SelectField fieldId="Field_156_search_request_type" fieldName="Request Type" fieldValue={props.Field_156_search_request_type}
            fieldOptions={masterData.requestTypeModelList} 
            isMandatory={false} isVisible={true} isEditable={true} 
            fieldOnChange={props.changeHandler} />
        </div>

        

        </div>
        <div className='row'>
        
        <div className='col-6 mx-auto'>
          <div className='float-end'>
          <button name='Field_157_request_search_search_button' className='btn btn-primary' onClick={props.clickHandler}>Search</button>
          </div>
        </div>
        
        </div>

 
      </div>
      
  )
}

export default RequestSearchHead