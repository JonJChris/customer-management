import React from 'react'
import TextField from '../../elements/TextField'
import SelectField from '../../elements/SelectField'
// import WorkflowRibbon from './WorkflowRibbon'
import { useSelector } from 'react-redux'
import { isFieldEditable, isFieldMandatory, isFieldVisible } from '../../utility/generalUtil'
import DateField from '../../elements/DateField'
import ActionBar from './ActionBar'
import { useNavigate } from 'react-router-dom'
const stages = [
  { stageId: '1', stageName: "Collect KYC", stageStatus: "COMPLETE" },
  { stageId: '2', stageName: "Add Products", stageStatus: "COMPLETE" },
  { stageId: '3', stageName: "Update Documents", stageStatus: "INPROGRESS" },
  { stageId: '4', stageName: "Review and Submit", stageStatus: "PENDING" },
  { stageId: '5', stageName: "Approval", stageStatus: "PENDING" },
  { stageId: '6', stageName: "Closed", stageStatus: "PENDING" },

]

const CustomerHead = (props) => {
  const masterData = useSelector(state => state.masterDataSlice);
  const navigate = useNavigate();
  return (
    
    <div className='mt-3 border border-rounded p-3'>
       
      <div className='row row-standard'>
        <div className='col-5'>
          <DateField fieldId="Field_197_customer_crated_date" fieldName="Created Date" fieldValue={props.Field_197_customer_crated_date}
            isMandatory={false} isVisible={true} isEditable={false} />
          
        </div>
        <div className='col-1'></div>
        <div className='col-5'>
          <TextField fieldId="Field_198_customer_created_by" fieldName="Created By" fieldValue={props.Field_198_customer_created_by}
            isMandatory={false} isVisible={true} isEditable={false} />
        </div>
        <div className='col-1'><button className='btn btn-primary' onClick={()=> navigate("/request/createAmendRequest", {state:{
          customerId: props.customerId,
          customerFirstName: props.customerFirstName,
          customerLastName: props.customerLastName,
           }})}>Maintain</button></div>
        
      </div>

      <div className='row row-standard'>
        <div className='col-5'>
          <TextField fieldId="Field_200_customer_last_updated_by" fieldName="Updated By" fieldValue={props.Field_200_customer_last_updated_by}
            isMandatory={false} isVisible={true} isEditable={false} />
        </div>
        <div className='col-1'></div>
        <div className='col-5'>
          
          <DateField fieldId="Field_199_customer_last_updated_date" fieldName="Updated Date" fieldValue={props.Field_199_customer_last_updated_date} 
           isMandatory={false} isVisible={true} isEditable={false} />
        </div>
      </div>
      {/* <WorkflowRibbon items={stages} /> */}

    </div>
  )
}

export default CustomerHead