import React from 'react'
import TextField from '../../elements/TextField'
import SelectField from '../../elements/SelectField'
import {useSelector} from 'react-redux';
import { useOutletContext } from 'react-router-dom';
import {isFieldEditable, isFieldMandatory, isFieldVisible} from '../../utility/generalUtil'

const CustomerAdditionalDetails = () => {
  const masterData = useSelector( state => state.masterDataSlice);
  const context = useOutletContext();
  const additionalDetail = context.additionalDetails
  const uiFieldStore = useSelector( state => state.UIFieldStoreSlice);
  return (
    <div className="tab-pane fade show active" id="home" role="tabpanel"  >
    <div className='m-2 section-standard' >
    <h6 className='tab-section-title'></h6>
    <div className='row row-standard'>
        <div className='col'>
        <SelectField fieldId="Field_180_educational_qualification" fieldName="Educational Qualification" fieldValue={additionalDetail.Field_180_educational_qualification} fieldPlaceholder=""  fieldOptions={masterData.educationLevelsList} 
        isMandatory={false} isVisible={true} isEditable={false} />
        </div>
        <div className='col'>
        <SelectField  fieldId="Field_181_occupation_type" fieldName="Occupation Type" fieldValue={additionalDetail.Field_181_occupation_type} fieldPlaceholder="" fieldOptions={masterData.professionModelList} 
        isMandatory={false} isVisible={true} isEditable={false} />
        </div>
    </div>
    
    <div className='row row-standard'>
        <div className='col'>
        <TextField fieldId="Field_182_organisation_name" fieldName="Organisation Name" fieldValue={additionalDetail.Field_182_organisation_name} fieldPlaceholder="" 
        isMandatory={false} isVisible={true} isEditable={false} />
        </div>
        <div className='col'>
        {/* <TextField  fieldId="129_designation" fieldName="Designation" fieldValue={} fieldPlaceholder="" 
        isMandatory={isFieldMandatory(uiFieldStore, '129_designation')} isVisible={isFieldVisible(uiFieldStore, '129_designation')} isEditable={isFieldEditable(uiFieldStore, '129_designation')} /> */}
        </div>
    </div>
  
    <div className='row row-standard'>
        <div className='col'>
        <SelectField fieldId="Field_183_yearly_income" fieldName="Yearly Income" fieldValue={additionalDetail.Field_183_yearly_income} fieldPlaceholder="" fieldOptions={masterData.yearlyIncomeModelList} 
        isMandatory={false} isVisible={true} isEditable={false} />
        </div>
        
        <div className='col'>
        <SelectField fieldId="Field_194_home_ownership_type" fieldName="Home Ownership Type" fieldValue={additionalDetail.Field_194_home_ownership_type} fieldPlaceholder="" fieldOptions={masterData.homeOwnershipTypeModelList} 
        isMandatory={false} isVisible={true} isEditable={false} />
        </div>
    </div>
    <hr />
    <h6 className='tab-section-title'>Nomination Details</h6>
    <div className='row row-standard'>
        <div className='col'>
        <SelectField fieldId="Field_184_nominee_relationship_type" fieldName="Relationship Type" fieldValue={additionalDetail.Field_184_nominee_relationship_type}  fieldPlaceholder="" fieldOptions={masterData.relationshipTypeModelList} 
        isMandatory={false} isVisible={true} isEditable={false} />
        </div>
        
        <div className='col'>
        <TextField fieldId="Field_195_nominee_date_of_birth" fieldName="Date of Birth" fieldValue={additionalDetail.Field_195_nominee_date_of_birth} fieldPlaceholder="" 
        isMandatory={false} isVisible={true} isEditable={false} />
        </div>
    </div>
    <div className='row row-standard'>
        <div className='col'>
        <TextField fieldId="Field_185_nominee_first_name" fieldName="First Name" fieldValue={additionalDetail.Field_185_nominee_first_name} fieldPlaceholder="" 
        isMandatory={false} isVisible={true} isEditable={false} />
        </div>
        
        <div className='col'>
        <TextField  fieldId="Field_186_nominee_last_name" fieldName="Last Name" fieldValue={additionalDetail.Field_186_nominee_last_name} fieldPlaceholder="" 
        isMandatory={false} isVisible={true} isEditable={false} />
        </div>
    </div>
    </div>
</div>
  )
}

export default CustomerAdditionalDetails