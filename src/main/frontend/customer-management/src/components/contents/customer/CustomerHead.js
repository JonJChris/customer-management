import React from 'react'
import TextField from '../../elements/TextField'
import SelectField from '../../elements/SelectField'
// import WorkflowRibbon from './WorkflowRibbon'
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

const CustomerHead = (props) => {
console.log(props)
  const masterData = useSelector(state => state.masterDataSlice);
  // const uiFieldStore = useSelector(state => state.UIFieldStoreSlice);

  return (
    <div className='mt-3 border border-rounded p-3'>
      <div className='row'>
        <div className='col-5'>
          <TextField fieldId="Field_197_customer_crated_date" fieldName="Created Date" fieldValue={props.Field_197_customer_crated_date}
            isMandatory={false} isVisible={true} isEditable={false} />
          
        </div>
        <div className='col-1'></div>
        <div className='col-5'>
          <TextField fieldId="Field_198_customer_created_by" fieldName="Created By" fieldValue={props.Field_198_customer_created_by}
            isMandatory={false} isVisible={true} isEditable={false} />
        </div>
      </div>

      <div className='row mt-3'>
        <div className='col-5'>
          <TextField fieldId="Field_199_customer_last_updated_date" fieldName="Updated By" fieldValue={props.Field_199_customer_last_updated_date}
            isMandatory={false} isVisible={true} isEditable={false} />
        </div>
        <div className='col-1'></div>
        <div className='col-5'>
          
          <TextField fieldId="Field_200_customer_last_updated_by" fieldName="Updated Date" fieldValue={props.Field_200_customer_last_updated_by} 
           isMandatory={false} isVisible={true} isEditable={false} />
        </div>
      </div>
      {/* <WorkflowRibbon items={stages} /> */}

    </div>
  )
}

export default CustomerHead