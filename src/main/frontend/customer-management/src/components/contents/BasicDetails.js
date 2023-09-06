import React from 'react'
import TextField from '../elements/TextField'
import SelectField from '../elements/SelectField'
import {useSelector} from 'react-redux';

const BasicDetails = () => {

  const masterData = useSelector( state => state.masterDataSlice);
  
  return (
    <div className="tab-pane fade show active" id="home" role="tabpanel"  >
    <div className='m-2' >
    <h6 className='tab-section-title'>Customer Details </h6>
    <div className='row'>
        <div className='col'>
        <TextField fieldId="104_customer_id" fieldName="Customer Id" isMandatory={true} isVisible={true} isEditable={true} />
        </div>
        <div className='col'>
        <SelectField  fieldId="105_customer_title" fieldName="Customer Title" fieldOptions={masterData.titleList} isMandatory={true} isVisible={true} isEditable={true}  />
        </div>
    </div>
    
    <div className='row'>
        <div className='col'>
        <TextField fieldId="106_customer_first_name" fieldName="Customer First Name" fieldPlaceholder="Enter Customer Firstname" isMandatory={true} isVisible={true} isEditable={false} />
        </div>
        <div className='col'>
        <TextField  fieldId="107_customer_last_name" fieldName="Customer Last Name" fieldPlaceholder="Enter Customer Lastname" isMandatory={true} isVisible={true} isEditable={true}/>
        </div>
    </div>
  
    <div className='row'>
        <div className='col'>
        <TextField fieldId="108_customer_display_name" fieldName="Customer Display Name" fieldPlaceholder="Enter Customer Display Name" isMandatory={true} isVisible={true} isEditable={true} />
        </div>
        
        <div className='col'>
        <SelectField  fieldId="109_customer_nationality" fieldName="Customer Nationality" fieldOptions={masterData.countryList}  isMandatory={true} isVisible={true} isEditable={true} />
        </div>
    </div>

   
    <div className='row'>
        <div className='col'>
        <TextField fieldId="110_customer_date_of_birth" fieldName="Customer Date of Birth" isMandatory={true} isVisible={true} isEditable={true} />
        </div>
        
        <div className='col'>
    
        </div>
    </div>
    
    <div className='row'>
        <div className='col'>
        <SelectField fieldId="112_customer_marital_status" fieldName="Customer Marital Status" fieldOptions={masterData.maritalStatusList}  isMandatory={true} isVisible={true} isEditable={true}  />
        </div>
        <div className='col'>
        <SelectField  fieldId="113_customer_type" fieldName="Customer Type" fieldOptions={masterData.customerTypeList}  isMandatory={true} isVisible={true} isEditable={true}  />
        </div>
    </div>
    </div>
</div>
  )
}

export default BasicDetails