import React from 'react'
import TextField from '../elements/TextField'
import SelectField from '../elements/SelectField'
import {useSelector} from 'react-redux';
import {isFieldEditable, isFieldMandatory, isFieldVisible} from '../functions/generalUtil'
import { useOutletContext } from "react-router-dom";

const BasicDetails = () => {

  const masterData = useSelector( state => state.masterDataSlice);
  const uiFieldStore = useSelector( state => state.UIFieldStoreSlice);
  const context = useOutletContext();
  const basicDetail = context.basicDetails



  return (
    <div className="tab-pane fade show active" id="home" role="tabpanel"  >
    <div className='m-2' >
    <h6 className='tab-section-title'>Customer Details </h6>
    <div className='row'>
        <div className='col'>
        <TextField fieldId="Field_104_customer_id" fieldName="Customer Id" fieldValue={ basicDetail&& basicDetail.customerId} 
        isMandatory={isFieldMandatory(uiFieldStore, 'Field_104_customer_id')} isVisible={isFieldVisible(uiFieldStore, 'Field_104_customer_id')} isEditable={isFieldEditable(uiFieldStore, 'Field_104_customer_id')} />
        </div>
        <div className='col'>
        <SelectField  fieldId="Field_105_customer_title" fieldName="Customer Title" fieldValue={basicDetail && basicDetail.userTitle} fieldOptions={masterData.titleModelList} 
        isMandatory={isFieldMandatory(uiFieldStore, 'Field_105_customer_title')} isVisible={isFieldVisible(uiFieldStore, 'Field_105_customer_title')} isEditable={isFieldEditable(uiFieldStore, 'Field_105_customer_title')} />
        </div>
    </div>
    
    <div className='row'>
        <div className='col'>
        <TextField fieldId="Field_106_customer_first_name" fieldName="Customer First Name" fieldValue={basicDetail && basicDetail.firstName}  fieldPlaceholder="Enter Customer Firstname" 
        isMandatory={isFieldMandatory(uiFieldStore, 'Field_106_customer_first_name')} isVisible={isFieldVisible(uiFieldStore, 'Field_104_customer_id')} isEditable={isFieldEditable(uiFieldStore, 'Field_106_customer_first_name')} />
        </div>
        <div className='col'>
        <TextField  fieldId="Field_107_customer_last_name" fieldName="Customer Last Name" fieldValue={basicDetail && basicDetail.lastName}  fieldPlaceholder="Enter Customer Lastname" 
        isMandatory={isFieldMandatory(uiFieldStore, 'Field_107_customer_last_name')} isVisible={isFieldVisible(uiFieldStore, 'Field_107_customer_last_name')} isEditable={isFieldEditable(uiFieldStore, 'Field_107_customer_last_name')} />
        </div>
    </div>
  
    <div className='row'>
        <div className='col'>
        <TextField fieldId="Field_108_customer_display_name" fieldName="Customer Display Name" fieldValue={basicDetail && basicDetail.displayName}  
        isMandatory={isFieldMandatory(uiFieldStore, 'Field_108_customer_display_name')} isVisible={isFieldVisible(uiFieldStore, 'Field_108_customer_display_name')} isEditable={isFieldEditable(uiFieldStore, 'Field_108_customer_display_name')} />
        </div>
        
        <div className='col'>
        <SelectField  fieldId="Field_109_customer_nationality" fieldName="Customer Nationality" fieldValue={basicDetail && basicDetail.nationality}  fieldOptions={masterData.countryModelList}  
        isMandatory={isFieldMandatory(uiFieldStore, 'Field_108_customer_display_name')} isVisible={isFieldVisible(uiFieldStore, 'Field_108_customer_display_name')} isEditable={isFieldEditable(uiFieldStore, 'Field_108_customer_display_name')} />
        </div>
    </div>

   
    <div className='row'>
        <div className='col'>
        <TextField fieldId="Field_110_customer_date_of_birth" fieldName="Customer Date of Birth"  fieldValue={basicDetail && basicDetail.dateOfBirth} 
        isMandatory={isFieldMandatory(uiFieldStore, 'Field_108_customer_display_name')} isVisible={isFieldVisible(uiFieldStore, 'Field_108_customer_display_name')} isEditable={isFieldEditable(uiFieldStore, 'Field_108_customer_display_name')} />
        </div>
        
        <div className='col'>
    
        </div>
    </div>
    
    <div className='row'>
        <div className='col'>
        <SelectField fieldId="Field_112_customer_marital_status" fieldName="Customer Marital Status" fieldValue={basicDetail && basicDetail.maritalStatus} fieldOptions={masterData.maritalStatusModelList}  
        isMandatory={isFieldMandatory(uiFieldStore, 'Field_104_customer_id.isVisible')} isVisible={isFieldVisible(uiFieldStore, 'Field_104_customer_id.isVisible')} isEditable={isFieldEditable(uiFieldStore, 'Field_104_customer_id.isVisible')} />
        </div>
        <div className='col'>
        <SelectField  fieldId="Field_113_customer_type" fieldName="Customer Type" fieldValue={basicDetail && basicDetail.customerType} fieldOptions={masterData.customerTypeModelList}  
        isMandatory={isFieldMandatory(uiFieldStore, 'Field_104_customer_id.isVisible')} isVisible={isFieldVisible(uiFieldStore, 'Field_104_customer_id.isVisible')} isEditable={isFieldEditable(uiFieldStore, 'Field_104_customer_id.isVisible')} />
        </div>
    </div>
    </div>
</div>
  )
}

export default BasicDetails