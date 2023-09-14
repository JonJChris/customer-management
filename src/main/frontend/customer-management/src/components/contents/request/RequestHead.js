import React from 'react'
import TextField from '../../elements/TextField'
import SelectField from '../../elements/SelectField'
import WorkflowRibbon from './WorkflowRibbon'
import { useSelector } from 'react-redux'
import { isFieldEditable, isFieldMandatory, isFieldVisible } from '../../utility/generalUtil'
import DateField from '../../elements/DateField'


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
          <DateField fieldId="Field_101_request_created" fieldName="Request Created" fieldValue={props.Field_101_request_created}
            isMandatory={isFieldMandatory(uiFieldStore, 'Field_101_request_created')} isVisible={isFieldVisible(uiFieldStore, 'Field_101_request_created')} isEditable={isFieldEditable(uiFieldStore, 'Field_101_request_created')} />
        </div>
        <div className='col-1'></div>
        <div className='col-5'>
          
          <SelectField fieldId="Field_103_request_stage" fieldName="Request Stage" fieldValue={props.Field_103_request_status} fieldOptions={masterData.stageTypeModelList}
           isMandatory={isFieldMandatory(uiFieldStore, 'Field_103_request_stage')} isVisible={isFieldVisible(uiFieldStore, 'Field_103_request_stage')} isEditable={isFieldEditable(uiFieldStore, 'Field_103_request_stage')} />
        </div>
      </div> 
      </div>
  )
}

export default RequestHead