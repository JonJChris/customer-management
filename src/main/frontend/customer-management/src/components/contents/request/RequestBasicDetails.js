import React from 'react'
import TextField from '../../elements/TextField'
import SelectField from '../../elements/SelectField'
import {useSelector} from 'react-redux';
import {isFieldEditable, isFieldMandatory, isFieldVisible, getFieldMaxLength} from '../../utility/generalUtil'
import { useOutletContext } from "react-router-dom";
import DateField from '../../elements/DateField';

const RequestBasicDetails = () => {

  const masterData = useSelector( state => state.masterDataSlice);
  const uiFieldStore = useSelector( state => state.UIFieldStoreSlice);
  const context = useOutletContext();
  const basicDetail = context.basicDetails



  return (
    <div className="tab-pane fade show active" id="home" role="tabpanel"  >
    <div className='m-2 section-standard' >
    <h6 className='tab-section-title'>Customer Details </h6>
    <div className='row row-standard'>
        <div className='col'>
        <TextField fieldId="Field_104_customer_id" fieldName="Customer Id" fieldValue={ basicDetail&& basicDetail.Field_104_customer_id} 
        isMandatory={isFieldMandatory(uiFieldStore, 'Field_104_customer_id')} isVisible={isFieldVisible(uiFieldStore, 'Field_104_customer_id')} isEditable={context.stageEditable && isFieldEditable(uiFieldStore, 'Field_104_customer_id')} 
        fieldOnChange={context.updateStateForBasicDetailTab} fieldMaxLength={getFieldMaxLength(uiFieldStore, 'Field_104_customer_id')}/>
        </div>
        <div className='col'>
        <SelectField  fieldId="Field_105_customer_title" fieldName="Customer Title" fieldValue={basicDetail && basicDetail.Field_105_customer_title} fieldOptions={masterData.titleModelList} 
        isMandatory={isFieldMandatory(uiFieldStore, 'Field_105_customer_title')} isVisible={isFieldVisible(uiFieldStore, 'Field_105_customer_title')} isEditable={context.stageEditable && isFieldEditable(uiFieldStore, 'Field_105_customer_title')} 
        fieldOnChange={context.updateStateForBasicDetailTab}/>
        </div>
    </div>
    
    <div className='row row-standard'>
        <div className='col'>
        <TextField fieldId="Field_106_customer_first_name" fieldName="Customer First Name" fieldValue={basicDetail && basicDetail.Field_106_customer_first_name}  fieldPlaceholder="Enter Customer First Name" 
        isMandatory={isFieldMandatory(uiFieldStore, 'Field_106_customer_first_name')} isVisible={isFieldVisible(uiFieldStore, 'Field_104_customer_id')} isEditable={context.stageEditable && isFieldEditable(uiFieldStore, 'Field_106_customer_first_name')} 
        fieldOnChange={context.updateStateForBasicDetailTab} fieldMaxLength={getFieldMaxLength(uiFieldStore, 'Field_106_customer_first_name')}/>
        </div>
        <div className='col'>
        <TextField  fieldId="Field_107_customer_last_name" fieldName="Customer Last Name" fieldValue={basicDetail && basicDetail.Field_107_customer_last_name}  fieldPlaceholder="Enter Customer Last Name" 
        isMandatory={isFieldMandatory(uiFieldStore, 'Field_107_customer_last_name')} isVisible={isFieldVisible(uiFieldStore, 'Field_107_customer_last_name')} isEditable={context.stageEditable && isFieldEditable(uiFieldStore, 'Field_107_customer_last_name')} 
        fieldOnChange={context.updateStateForBasicDetailTab} fieldMaxLength={getFieldMaxLength(uiFieldStore, 'Field_107_customer_last_name')}/>
        </div>
    </div>
  
    <div className='row row-standard'>
        <div className='col'>
        <TextField fieldId="Field_108_customer_display_name" fieldName="Customer Display Name" fieldValue={basicDetail && basicDetail.Field_108_customer_display_name}  
        isMandatory={isFieldMandatory(uiFieldStore, 'Field_108_customer_display_name')} isVisible={isFieldVisible(uiFieldStore, 'Field_108_customer_display_name')} isEditable={context.stageEditable && isFieldEditable(context.stageEditable &&  uiFieldStore, 'Field_108_customer_display_name')} 
        fieldOnChange={context.updateStateForBasicDetailTab} fieldMaxLength={getFieldMaxLength(uiFieldStore, 'Field_108_customer_display_name')}/>
        </div>
        
        <div className='col'>
        <SelectField  fieldId="Field_109_customer_nationality" fieldName="Customer Nationality" fieldValue={basicDetail && basicDetail.Field_109_customer_nationality}  fieldOptions={masterData.countryModelList}  
        isMandatory={isFieldMandatory(uiFieldStore, 'Field_108_customer_display_name')} isVisible={isFieldVisible(uiFieldStore, 'Field_108_customer_display_name')} isEditable={context.stageEditable && isFieldEditable(uiFieldStore, 'Field_108_customer_display_name')} 
        fieldOnChange={context.updateStateForBasicDetailTab}/>
        </div>
    </div>

   
    <div className='row row-standard'>
        <div className='col'>
        <DateField fieldId="Field_110_customer_date_of_birth" fieldName="Customer Date of Birth"  fieldValue={basicDetail && basicDetail.Field_110_customer_date_of_birth} 
        isMandatory={isFieldMandatory(uiFieldStore, 'Field_108_customer_display_name')} isVisible={isFieldVisible(uiFieldStore, 'Field_108_customer_display_name')} isEditable={context.stageEditable &&  isFieldEditable(uiFieldStore, 'Field_108_customer_display_name')} 
        fieldOnChange={context.updateStateForBasicDetailTab}/>
        </div>
        
        <div className='col'>
        <TextField fieldId="Field_144_customer_email" fieldName="Email"  fieldValue={basicDetail && basicDetail.Field_144_customer_email} 
        isMandatory={isFieldMandatory(uiFieldStore, 'Field_144_customer_email')} isVisible={isFieldVisible(uiFieldStore, 'Field_144_customer_email')} isEditable={context.stageEditable && isFieldEditable(uiFieldStore, 'Field_144_customer_email')} 
        fieldOnChange={context.updateStateForBasicDetailTab} fieldMaxLength={getFieldMaxLength(uiFieldStore, 'Field_144_customer_email')}/>
        </div>
    </div>
    
    <div className='row row-standard'>
        <div className='col'>
        <SelectField fieldId="Field_112_customer_marital_status" fieldName="Customer Marital Status" fieldValue={basicDetail && basicDetail.Field_112_customer_marital_status} fieldOptions={masterData.maritalStatusModelList}  
        isMandatory={isFieldMandatory(uiFieldStore, 'Field_104_customer_id.isVisible')} isVisible={isFieldVisible(uiFieldStore, 'Field_104_customer_id.isVisible')} isEditable={context.stageEditable && isFieldEditable(uiFieldStore, 'Field_104_customer_id.isVisible')} 
        fieldOnChange={context.updateStateForBasicDetailTab}/>
        </div>
        <div className='col'>
        <SelectField  fieldId="Field_113_customer_type" fieldName="Customer Type" fieldValue={basicDetail && basicDetail.Field_113_customer_type} fieldOptions={masterData.customerTypeModelList}  
        isMandatory={isFieldMandatory(uiFieldStore, 'Field_104_customer_id.isVisible')} isVisible={isFieldVisible(uiFieldStore, 'Field_104_customer_id.isVisible')} isEditable={context.stageEditable && isFieldEditable(uiFieldStore, 'Field_104_customer_id.isVisible')} 
        fieldOnChange={context.updateStateForBasicDetailTab}/>
        </div>
    </div>
    </div>
</div>
  )
}

export default RequestBasicDetails