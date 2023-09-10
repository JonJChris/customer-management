import React from 'react'
import TextField from '../../elements/TextField'
import SelectField from '../../elements/SelectField'
import WorkflowRibbon from './../Request/WorkflowRibbon'
import { useSelector } from 'react-redux'
import { isFieldEditable, isFieldMandatory, isFieldVisible } from '../../utility/generalUtil'
const stages = [
  { stageId: '1', stageName: "Collect KYC", stageStatus: "COMPLETE" },
  { stageId: '2', stageName: "Add Products", stageStatus: "COMPLETE" },
  { stageId: '3', stageName: "Update Documents", stageStatus: "INPROGRESS" },
  { stageId: '4', stageName: "Review and Submit", stageStatus: "PENDING" },
  { stageId: '5', stageName: "Approval", stageStatus: "PENDING" },
  { stageId: '6', stageName: "Closed", stageStatus: "PENDING" },

]

const SearchHeadCustomer = (props) => {

  const masterData = useSelector(state => state.masterDataSlice);
  const uiFieldStore = useSelector(state => state.UIFieldStoreSlice);

  return (
    <div className='mt-3 border border-rounded p-3'>
      <div className='row'>
      
        <div className='col-6 mx-auto'>
          <TextField fieldId="Field_147_search_customer_id" fieldName="Customer Id" fieldValue={props.Field_147_search_customer_id}
           fieldOnChange={props.changeHandler}  isMandatory={false} isVisible={true} isEditable={true}/>
        </div>
      
        </div>
        <div className='row'>
        
        <div className='col-6 mx-auto'>
          <TextField fieldId="Field_148_search_customer_first_name" fieldName="First Name" fieldValue={props.Field_148_search_customer_first_name}
            fieldOnChange={props.changeHandler} isMandatory={false} isVisible={true} isEditable={true}/>
        </div>
        
        </div>
        
        <div className='row'>
        
        <div className='col-6 mx-auto'>
          <TextField fieldId="Field_149_search_customer_last_name" fieldName="Last Name" fieldValue={props.Field_149_search_customer_last_name}
           fieldOnChange={props.changeHandler} isMandatory={false} isVisible={true} isEditable={true}/>
        </div>
        
        </div>

        <div className='row'>

        <div className='col-6 mx-auto'>
          <SelectField fieldId="Field_150_search_customer_nationality" fieldName="Nationality" fieldValue={props.Field_150_search_customer_nationality}
            fieldOptions={masterData.countryModelList} 
            isMandatory={false} isVisible={true} isEditable={true} 
            fieldOnChange={props.changeHandler} />
        </div>

        

        </div>
        <div className='row'>
        
        <div className='col-6 mx-auto'>
          <div className='float-end'>
          <button name='Field_151_customer_search_search_button' className='btn btn-primary' onClick={props.clickHandler}>Search</button>
          </div>
        </div>
        
        </div>

 
      </div>
      
  )
}

export default SearchHeadCustomer