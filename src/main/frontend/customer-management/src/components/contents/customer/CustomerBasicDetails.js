import React from 'react'
import TextField from '../../elements/TextField'
import SelectField from '../../elements/SelectField'
import {useSelector} from 'react-redux';
import {isFieldEditable, isFieldMandatory, isFieldVisible} from '../../utility/generalUtil'
import { useOutletContext } from "react-router-dom";

const CustomerBasicDetails = () => {

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
        <TextField fieldId="Field_159_customer_id" fieldName="Customer Id" fieldValue={ basicDetail&& basicDetail.Field_159_customer_id} 
        isMandatory={false} isVisible={true} isEditable={false} />
        </div>
        <div className='col'>
        <SelectField  fieldId="Field_160_customer_title" fieldName="Customer Title" fieldValue={basicDetail && basicDetail.Field_160_customer_title} fieldOptions={masterData.titleModelList} 
        isMandatory={false} isVisible={true} isEditable={false} />
        </div>
    </div>
    
    <div className='row row-standard'>
        <div className='col'>
        <TextField fieldId="Field_161_customer_first_name" fieldName="Customer First Name" fieldValue={basicDetail && basicDetail.Field_161_customer_first_name}  fieldPlaceholder="Enter Customer First Name" 
        isMandatory={false} isVisible={true} isEditable={false} />
        </div>
        <div className='col'>
        <TextField  fieldId="Field_162_customer_last_name" fieldName="Customer Last Name" fieldValue={basicDetail && basicDetail.Field_162_customer_last_name}  fieldPlaceholder="Enter Customer Last Name" 
        isMandatory={false} isVisible={true} isEditable={false} />
        </div>
    </div>
  
    <div className='row row-standard'>
        <div className='col'>
        <TextField fieldId="Field_163_customer_display_name" fieldName="Customer Display Name" fieldValue={basicDetail && basicDetail.Field_163_customer_display_name}  
        isMandatory={false} isVisible={true} isEditable={false} />
        </div>
        
        <div className='col'>
        <SelectField  fieldId="Field_164_customer_nationality" fieldName="Customer Nationality" fieldValue={basicDetail && basicDetail.Field_164_customer_nationality}  fieldOptions={masterData.countryModelList}  
        isMandatory={false} isVisible={true} isEditable={false} />
        </div>
    </div>

   
    <div className='row row-standard'>
        <div className='col'>
        <TextField fieldId="Field_165_customer_date_of_birth" fieldName="Customer Date of Birth"  fieldValue={basicDetail && basicDetail.Field_165_customer_date_of_birth} 
        isMandatory={false} isVisible={true} isEditable={false} />
        </div>
        
        <div className='col'>
        <TextField fieldId="Field_196_customer_email" fieldName="Email"  fieldValue={basicDetail && basicDetail.Field_196_customer_email} 
        isMandatory={false} isVisible={true} isEditable={false} />
        </div>
    </div>
    
    <div className='row row-standard'>
        <div className='col'>
        <SelectField fieldId="Field_166_customer_marital_status" fieldName="Customer Marital Status" fieldValue={basicDetail && basicDetail.Field_166_customer_marital_status} fieldOptions={masterData.maritalStatusModelList}  
        isMandatory={false} isVisible={true} isEditable={false} />
        </div>
        <div className='col'>
        <SelectField  fieldId="Field_167_customer_type" fieldName="Customer Type" fieldValue={basicDetail && basicDetail.Field_167_customer_type} fieldOptions={masterData.customerTypeModelList}  
        isMandatory={false} isVisible={true} isEditable={false} />
        </div>
    </div>
    </div>
</div>
  )
}

export default CustomerBasicDetails