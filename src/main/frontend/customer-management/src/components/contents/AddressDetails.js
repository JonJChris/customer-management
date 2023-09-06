import React from 'react'
import TextField from '../elements/TextField'
import SelectField from '../elements/SelectField'
import {useSelector} from 'react-redux';

const AddressDetails = () => {
const masterData = useSelector( state => state.masterDataSlice);
  return (
    <div className="tab-pane fade show active" id="home" role="tabpanel"  >
        <div className='m-2' >
        <h6 className='tab-section-title'>Registered Address </h6>
        <div className='row'>
            <div className='col'>
            <TextField fieldId="114_reg_address_line1" fieldName="Address Line 1"  isMandatory={true} isVisible={true} isEditable={true}  />
            </div>
            <div className='col'>
            <TextField  fieldId="115_reg_address_line2" fieldName="Address Line 2" fieldPlaceholder=""  isMandatory={true} isVisible={true} isEditable={true} />
            </div>
        </div>
        
        <div className='row'>
            <div className='col'>
            <TextField fieldId="116_reg_address_city" fieldName="City" fieldPlaceholder="Enter Customer Firstname"  isMandatory={true} isVisible={true} isEditable={true} />
            </div>
            <div className='col'>
            <TextField  fieldId="117_reg_address_state" fieldName="State" fieldPlaceholder="Enter Customer Lastname"  isMandatory={true} isVisible={true} isEditable={true} />
            </div>
        </div>
      
        <div className='row'>
            <div className='col'>
            <SelectField fieldId="118_reg_address_country" fieldName="Country" fieldPlaceholder="Enter Customer Display Name" fieldOptions={masterData.countryList} isMandatory={true} isVisible={true} isEditable={true} />
            </div>
            
            <div className='col'>
            <TextField  fieldId="119_reg_address_postal_code" fieldName="PostalCode" fieldPlaceholder="Enter Customer Nationality"  isMandatory={true} isVisible={true} isEditable={true} />
            </div>
        </div>

    <hr />

    <h6 className='tab-section-title'>Communication Address </h6>
        <div className='row'>
            <div className='col'>
            <TextField fieldId="120_com_address_line1" fieldName="Address Line 1" fieldPlaceholder=""  isMandatory={true} isVisible={true} isEditable={true} />
            </div>
            <div className='col'>
            <TextField  fieldId="121_com_address_line2" fieldName="Address Line 2" fieldPlaceholder=""  isMandatory={true} isVisible={true} isEditable={true} />
            </div>
        </div>
        
        <div className='row'>
            <div className='col'>
            <TextField fieldId="122_com_address_city" fieldName="City" fieldPlaceholder="Enter Customer Firstname"  isMandatory={true} isVisible={true} isEditable={true} />
            </div>
            <div className='col'>
            <TextField  fieldId="123_com_address_state" fieldName="State" fieldPlaceholder="Enter Customer Lastname"  isMandatory={true} isVisible={true} isEditable={true} />
            </div>
        </div>
      
        <div className='row'>
            <div className='col'>
            <SelectField fieldId="124_com_address_country" fieldName="Country" fieldPlaceholder="Enter Customer Display Name" fieldOptions={masterData.countryList} isMandatory={true} isVisible={true} isEditable={true} />
            </div>
            
            <div className='col'>
            <TextField  fieldId="125_com_address_postal_code" fieldName="Postal Code" fieldPlaceholder="Enter Customer Nationality"  isMandatory={true} isVisible={true} isEditable={true} />
            </div>
        </div>

        </div>
    </div>
  )
}

export default AddressDetails