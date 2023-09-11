import React from 'react'
import TextField from '../../elements/TextField'
import SelectField from '../../elements/SelectField'
import WorkflowRibbon from './WorkflowRibbon'
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

const RequestHead = (props) => {

  const masterData = useSelector(state => state.masterDataSlice);
  const uiFieldStore = useSelector(state => state.UIFieldStoreSlice);

  return (
    <div className='mt-3 border border-rounded p-3'>
      <div className='row'>
        <div className='col-5'>
          <TextField fieldId="Field_100_request_id" fieldName="Request Id" fieldValue={props.Field_100_request_id}
            isMandatory={isFieldMandatory(uiFieldStore, 'Field_100_request_id')} isVisible={isFieldVisible(uiFieldStore, 'Field_100_request_id')} isEditable={isFieldEditable(uiFieldStore, 'Field_100_request_id')}
          />
        </div>
        <div className='col-1'></div>
        <div className='col-5'>
          <SelectField fieldId="Field_102_request_type" fieldName="Request Type" fieldValue={props.Field_102_request_type} fieldOptions={masterData.requestTypeModelList}
            isMandatory={isFieldMandatory(uiFieldStore, 'Field_102_request_type')} isVisible={isFieldVisible(uiFieldStore, 'Field_102_request_type')} isEditable={isFieldEditable(uiFieldStore, 'Field_102_request_type')} />
        </div>
      </div>

      <div className='row mt-3'>
        <div className='col-5'>
          <TextField fieldId="Field_101_request_created" fieldName="Request Created" fieldValue={props.Field_101_request_created}
            isMandatory={isFieldMandatory(uiFieldStore, 'Field_101_request_created')} isVisible={isFieldVisible(uiFieldStore, 'Field_101_request_created')} isEditable={isFieldEditable(uiFieldStore, 'Field_101_request_created')} />
        </div>
        <div className='col-1'></div>
        <div className='col-5'>
          
          <SelectField fieldId="Field_103_request_stage" fieldName="Request Stage" fieldValue={props.Field_103_request_status} fieldOptions={masterData.requestStageModelList}
           isMandatory={isFieldMandatory(uiFieldStore, 'Field_103_request_stage')} isVisible={isFieldVisible(uiFieldStore, 'Field_103_request_stage')} isEditable={isFieldEditable(uiFieldStore, 'Field_103_request_stage')} />
        </div>
      </div>
      <WorkflowRibbon items={stages} />

    </div>
  )
}

export default RequestHead