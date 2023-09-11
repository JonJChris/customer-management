import React from 'react'
import TextField from '../../elements/TextField'
import SelectField from '../../elements/SelectField'
import {useSelector} from 'react-redux';
import {isFieldEditable, isFieldMandatory, isFieldVisible} from '../../utility/generalUtil'
import { useOutletContext } from 'react-router-dom';

const RequestAddressDetails = () => {
const masterData = useSelector( state => state.masterDataSlice);
const context = useOutletContext();
const addressDetail = context.addressDetails
const uiFieldStore = useSelector( state => state.UIFieldStoreSlice);
  return (
    <div className="tab-pane fade show active" id="home" role="tabpanel"  >
        <div className='m-2' >
        <h6 className='tab-section-title'>Registered Address </h6>
        <div className='row'>
            <div className='col'>
            <TextField fieldId="Field_114_reg_address_line1" fieldName="Address Line 1" fieldValue={addressDetail.Field_114_reg_address_line1} 
            isMandatory={isFieldMandatory(uiFieldStore, 'Field_114_reg_address_line1')} isVisible={isFieldVisible(uiFieldStore, 'Field_114_reg_address_line1')} isEditable={isFieldEditable(uiFieldStore, 'Field_114_reg_address_line1')} 
            fieldOnChange={context.updateStateForAddressTab}/>
            </div>
            <div className='col'>
            <TextField  fieldId="Field_115_reg_address_line2" fieldName="Address Line 2" fieldValue={addressDetail.Field_115_reg_address_line2} fieldPlaceholder=""  
            isMandatory={isFieldMandatory(uiFieldStore, 'Field_115_reg_address_line2')} isVisible={isFieldVisible(uiFieldStore, 'Field_115_reg_address_line2')} isEditable={isFieldEditable(uiFieldStore, 'Field_10Field_115_reg_address_line28_customer_display_name')} 
            fieldOnChange={context.updateStateForAddressTab}/>
            </div>
        </div>
        
        <div className='row'>
            <div className='col'>
            <TextField fieldId="Field_116_reg_address_city" fieldName="City" fieldValue={addressDetail.Field_116_reg_address_city} fieldPlaceholder="Enter Customer First Name"  
            isMandatory={isFieldMandatory(uiFieldStore, 'Field_116_reg_address_city')} isVisible={isFieldVisible(uiFieldStore, 'Field_116_reg_address_city')} isEditable={isFieldEditable(uiFieldStore, 'Field_116_reg_address_city')} 
            fieldOnChange={context.updateStateForAddressTab}/>
            </div>
            <div className='col'>
            <TextField  fieldId="Field_117_reg_address_state" fieldName="State" fieldValue={addressDetail.Field_117_reg_address_state} fieldPlaceholder="Enter Customer Lastname"  
            isMandatory={isFieldMandatory(uiFieldStore, 'Field_117_reg_address_state')} isVisible={isFieldVisible(uiFieldStore, 'Field_117_reg_address_state')} isEditable={isFieldEditable(uiFieldStore, 'Field_117_reg_address_state')} 
            fieldOnChange={context.updateStateForAddressTab}/>
            </div>
        </div>
      
        <div className='row'>
            <div className='col'>
            <SelectField fieldId="Field_118_reg_address_country" fieldName="Country" fieldValue={addressDetail.Field_118_reg_address_country} fieldPlaceholder="Enter Customer Display Name" fieldOptions={masterData.countryModelList} 
            isMandatory={isFieldMandatory(uiFieldStore, 'Field_118_reg_address_country')} isVisible={isFieldVisible(uiFieldStore, 'Field_118_reg_address_country')} isEditable={isFieldEditable(uiFieldStore, 'Field_118_reg_address_country')} 
            fieldOnChange={context.updateStateForAddressTab}/>
            </div>
            
            <div className='col'>
            <TextField  fieldId="Field_119_reg_address_postal_code" fieldName="PostalCode" fieldValue={addressDetail.Field_119_reg_address_postal_code} fieldPlaceholder="Enter Customer Nationality"  
            isMandatory={isFieldMandatory(uiFieldStore, 'Field_119_reg_address_postal_code')} isVisible={isFieldVisible(uiFieldStore, 'Field_119_reg_address_postal_code')} isEditable={isFieldEditable(uiFieldStore, 'Field_119_reg_address_postal_code')} 
            fieldOnChange={context.updateStateForAddressTab}/>
            </div>
        </div>

    <hr />

    <h6 className='tab-section-title'>Communication Address </h6>
        <div className='row'>
            <div className='col'>
            <TextField fieldId="Field_120_com_address_line1" fieldName="Address Line 1" fieldValue={addressDetail.Field_120_com_address_line1} fieldPlaceholder=""  
            isMandatory={isFieldMandatory(uiFieldStore, 'Field_120_com_address_line1')} isVisible={isFieldVisible(uiFieldStore, 'Field_120_com_address_line1')} isEditable={isFieldEditable(uiFieldStore, 'Field_120_com_address_line1')} 
            fieldOnChange={context.updateStateForAddressTab}/>
            </div>
            <div className='col'>
            <TextField  fieldId="Field_121_com_address_line2" fieldName="Address Line 2" fieldValue={addressDetail.Field_121_com_address_line2} fieldPlaceholder=""  
            isMandatory={isFieldMandatory(uiFieldStore, 'Field_121_com_address_line2')} isVisible={isFieldVisible(uiFieldStore, 'Field_121_com_address_line2')} isEditable={isFieldEditable(uiFieldStore, 'Field_121_com_address_line2')} 
            fieldOnChange={context.updateStateForAddressTab}/>
            </div>
        </div>
        
        <div className='row'>
            <div className='col'>
            <TextField fieldId="Field_122_com_address_city" fieldName="City" fieldValue={addressDetail.Field_122_com_address_city} fieldPlaceholder="Enter Customer Firstname" 
            isMandatory={isFieldMandatory(uiFieldStore, 'Field_122_com_address_city')} isVisible={isFieldVisible(uiFieldStore, 'Field_122_com_address_city')} isEditable={isFieldEditable(uiFieldStore, 'Field_122_com_address_city')} 
            fieldOnChange={context.updateStateForAddressTab}/>
            </div>
            <div className='col'>
            <TextField  fieldId="Field_123_com_address_state" fieldName="State" fieldValue={addressDetail.Field_123_com_address_state} fieldPlaceholder="Enter Customer Lastname"  
            isMandatory={isFieldMandatory(uiFieldStore, 'Field_123_com_address_state')} isVisible={isFieldVisible(uiFieldStore, 'Field_123_com_address_state')} isEditable={isFieldEditable(uiFieldStore, 'Field_123_com_address_state')} 
            fieldOnChange={context.updateStateForAddressTab}/>
            </div>
        </div>
      
        <div className='row'>
            <div className='col'>
            <SelectField fieldId="Field_124_com_address_country" fieldName="Country" fieldValue={addressDetail.Field_124_com_address_country} fieldPlaceholder="Enter Customer Display Name" fieldOptions={masterData.countryModelList} 
            isMandatory={isFieldMandatory(uiFieldStore, 'Field_124_com_address_country')} isVisible={isFieldVisible(uiFieldStore, 'Field_124_com_address_country')} isEditable={isFieldEditable(uiFieldStore, 'Field_124_com_address_country')} 
            fieldOnChange={context.updateStateForAddressTab}/>
            </div>
            
            <div className='col'>
            <TextField  fieldId="Field_125_com_address_postal_code" fieldName="Postal Code" fieldValue={addressDetail.Field_125_com_address_postal_code} fieldPlaceholder="Enter Customer Nationality"  
            isMandatory={isFieldMandatory(uiFieldStore, 'Field_125_com_address_postal_code')} isVisible={isFieldVisible(uiFieldStore, 'Field_125_com_address_postal_code')} isEditable={isFieldEditable(uiFieldStore, 'Field_125_com_address_postal_code')} 
            fieldOnChange={context.updateStateForAddressTab}/>
            </div>
        </div>

        </div>
    </div>
  )
}

export default RequestAddressDetails