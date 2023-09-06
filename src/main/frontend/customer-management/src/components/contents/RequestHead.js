import React from 'react'
import TextField from '../elements/TextField'
import SelectField from '../elements/SelectField'
import WorkflowRibbon from './WorkflowRibbon'
import {useSelector} from 'react-redux'

const stages = [
    {stageId:'1', stageName:"Collect KYC", stageStatus:"COMPLETE"},
    {stageId:'2', stageName:"Add Products", stageStatus:"COMPLETE"},
    {stageId:'3', stageName:"Update Documents", stageStatus:"INPROGRESS"},
    {stageId:'4', stageName:"Review and Submit", stageStatus:"PENDING"},
    {stageId:'5', stageName:"Approval", stageStatus:"PENDING"},
    {stageId:'6', stageName:"Closed", stageStatus:"PENDING"},
    
]

const RequestHead = () => {
  const masterData = useSelector( state => state.masterDataSlice);
  return (
    <div className='mt-3 border border-rounded p-3'>
        <div className='row'>
            <div className='col-5'>
            <TextField fieldId="100_request_id" fieldName="Request Id" isMandatory={true} isVisible={true} isEditable={true}/>
            </div>
            <div className='col-1'></div>
            <div className='col-5'>
            <SelectField fieldId="102_request_type"  fieldName="Request Type"  fieldOptions={masterData.requestTypesList} isMandatory={true} isEditable={true}/>
            </div>
        </div>
        
        <div className='row mt-3'>
            <div className='col-5'>
            <TextField fieldId="101_request_created"  fieldName="Request Created" isMandatory={true} isVisible={true} isEditable={true} />
            </div>
            <div className='col-1'></div>
            <div className='col-5'>
            <SelectField  fieldId="103_request_status"  fieldName="Request Status" fieldOptions={masterData.requestStageList} isMandatory={true} isVisible={true} isEditable={true}/>
            </div>
        </div>
        <WorkflowRibbon items={stages}/>
       
    </div>
  )
}

export default RequestHead