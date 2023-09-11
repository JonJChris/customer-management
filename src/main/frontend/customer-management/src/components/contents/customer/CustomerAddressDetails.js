import React from 'react'
import TextField from '../../elements/TextField'
import SelectField from '../../elements/SelectField'
import {useSelector} from 'react-redux';
import {isFieldEditable, isFieldMandatory, isFieldVisible} from '../../utility/generalUtil'
import { useOutletContext } from 'react-router-dom';

const CustomerAddressDetails = () => {
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
            <TextField fieldId="Field_168_reg_address_line1" fieldName="Address Line 1" fieldValue={addressDetail.Field_168_reg_address_line1} 
            isMandatory={false} isVisible={true} isEditable={false} />
            </div>
            <div className='col'>
            <TextField  fieldId="Field_169_reg_address_line2" fieldName="Address Line 2" fieldValue={addressDetail.Field_169_reg_address_line2} fieldPlaceholder=""  
            isMandatory={false} isVisible={true} isEditable={false} />
            </div>
        </div>
        
        <div className='row'>
            <div className='col'>
            <TextField fieldId="Field_170_reg_address_city" fieldName="City" fieldValue={addressDetail.Field_170_reg_address_city} fieldPlaceholder="Enter Customer First Name"  
            isMandatory={false} isVisible={true} isEditable={false} />
            </div>
            <div className='col'>
            <TextField  fieldId="Field_171_reg_address_state" fieldName="State" fieldValue={addressDetail.Field_171_reg_address_state} fieldPlaceholder="Enter Customer Lastname"  
            isMandatory={false} isVisible={true} isEditable={false} />
            </div>
        </div>
      
        <div className='row'>
            <div className='col'>
            <SelectField fieldId="Field_172_reg_address_country" fieldName="Country" fieldValue={addressDetail.Field_172_reg_address_country} fieldPlaceholder="Enter Customer Display Name" fieldOptions={masterData.countryModelList} 
            isMandatory={false} isVisible={true} isEditable={false} />
            </div>
            
            <div className='col'>
            <TextField  fieldId="Field_173_reg_address_postal_code" fieldName="PostalCode" fieldValue={addressDetail.Field_173_reg_address_postal_code} fieldPlaceholder="Enter Customer Nationality"  
            isMandatory={false} isVisible={true} isEditable={false} />
            </div>
        </div>

    <hr />

    <h6 className='tab-section-title'>Communication Address </h6>
        <div className='row'>
            <div className='col'>
            <TextField fieldId="Field_174_com_address_line1" fieldName="Address Line 1" fieldValue={addressDetail.Field_174_com_address_line1} fieldPlaceholder=""  
            isMandatory={false} isVisible={true} isEditable={false} />
            </div>
            <div className='col'>
            <TextField  fieldId="Field_175_com_address_line2" fieldName="Address Line 2" fieldValue={addressDetail.Field_175_com_address_line2} fieldPlaceholder=""  
            isMandatory={false} isVisible={true} isEditable={false} />
            </div>
        </div>
        
        <div className='row'>
            <div className='col'>
            <TextField fieldId="Field_176_com_address_city" fieldName="City" fieldValue={addressDetail.Field_176_com_address_city} fieldPlaceholder="Enter Customer Firstname" 
            isMandatory={false} isVisible={true} isEditable={false} />
            </div>
            <div className='col'>
            <TextField  fieldId="Field_177_com_address_state" fieldName="State" fieldValue={addressDetail.Field_177_com_address_state} fieldPlaceholder="Enter Customer Lastname"  
            isMandatory={false} isVisible={true} isEditable={false} />
            </div>
        </div>
      
        <div className='row'>
            <div className='col'>
            <SelectField fieldId="Field_178_com_address_country" fieldName="Country" fieldValue={addressDetail.Field_178_com_address_country} fieldPlaceholder="Enter Customer Display Name" fieldOptions={masterData.countryModelList} 
            isMandatory={false} isVisible={true} isEditable={false} />
            </div>
            
            <div className='col'>
            <TextField  fieldId="Field_179_com_address_postal_code" fieldName="Postal Code" fieldValue={addressDetail.Field_179_com_address_postal_code} fieldPlaceholder="Enter Customer Nationality"  
            isMandatory={false} isVisible={true} isEditable={false} />
            </div>
        </div>

        </div>
    </div>
  )
}

export default CustomerAddressDetails