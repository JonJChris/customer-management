import React from 'react'
import TextField from '../elements/TextField'
import SelectField from '../elements/SelectField'
import {useSelector} from 'react-redux';
import { useOutletContext } from 'react-router-dom';
import {isFieldEditable, isFieldMandatory, isFieldVisible} from '../functions/generalUtil'

const AdditionalDetails = () => {
  const masterData = useSelector( state => state.masterDataSlice);
  const context = useOutletContext();
  const additinalDetail = context.additionalDetails
  const uiFieldStore = useSelector( state => state.UIFieldStoreSlice);
  return (
    <div className="tab-pane fade show active" id="home" role="tabpanel"  >
    <div className='m-2' >
    <h6 className='tab-section-title'></h6>
    <div className='row'>
        <div className='col'>
        <SelectField fieldId="Field_126_educational_qualification" fieldName="Educational Qualification" fieldValue={additinalDetail.customerEducationLevel} fieldPlaceholder=""  fieldOptions={masterData.educationLevelsList} 
        isMandatory={isFieldMandatory(uiFieldStore, 'Field_126_educational_qualification')} isVisible={isFieldVisible(uiFieldStore, 'Field_126_educational_qualification')} isEditable={isFieldEditable(uiFieldStore, 'Field_126_educational_qualification')} />
        </div>
        <div className='col'>
        <SelectField  fieldId="Field_127_occupation_type" fieldName="Occupation Type" fieldValue={additinalDetail.customerProfession} fieldPlaceholder="" fieldOptions={masterData.professionModelList} 
        isMandatory={isFieldMandatory(uiFieldStore, 'Field_127_occupation_type')} isVisible={isFieldVisible(uiFieldStore, 'Field_127_occupation_type')} isEditable={isFieldEditable(uiFieldStore, 'Field_127_occupation_type')} />
        </div>
    </div>
    
    <div className='row'>
        <div className='col'>
        <TextField fieldId="Field_128_organisation_name" fieldName="Organisation Name" fieldValue={additinalDetail.customerOrganisationName} fieldPlaceholder="" 
        isMandatory={isFieldMandatory(uiFieldStore, 'Field_128_organisation_name')} isVisible={isFieldVisible(uiFieldStore, 'Field_128_organisation_name')} isEditable={isFieldEditable(uiFieldStore, 'Field_128_organisation_name')} />
        </div>
        <div className='col'>
        {/* <TextField  fieldId="129_designation" fieldName="Designation" fieldValue={} fieldPlaceholder="" 
        isMandatory={isFieldMandatory(uiFieldStore, '129_designation')} isVisible={isFieldVisible(uiFieldStore, '129_designation')} isEditable={isFieldEditable(uiFieldStore, '129_designation')} /> */}
        </div>
    </div>
  
    <div className='row'>
        <div className='col'>
        <SelectField fieldId="Field_130_yearly_income" fieldName="Yearly Income" fieldValue={additinalDetail.customerYearlyIncome} fieldPlaceholder="" fieldOptions={masterData.yearlyIncomeModelList} 
        isMandatory={isFieldMandatory(uiFieldStore, 'Field_130_yearly_income')} isVisible={isFieldVisible(uiFieldStore, 'Field_130_yearly_income')} isEditable={isFieldEditable(uiFieldStore, 'Field_130_yearly_income')} />
        </div>
        
        <div className='col'>
        <SelectField fieldId="Field_142_home_ownership_type" fieldName="Home Ownership Type" fieldValue={additinalDetail.homeOwnershipType} fieldPlaceholder="" fieldOptions={masterData.homeOwnershipTypeModelList} 
        isMandatory={isFieldMandatory(uiFieldStore, 'Field_142_home_ownership_type')} isVisible={isFieldVisible(uiFieldStore, 'Field_142_home_ownership_type')} isEditable={isFieldEditable(uiFieldStore, 'Field_142_home_ownership_type')} />
        </div>
    </div>
    <hr />
    <h6 className='tab-section-title'>Nomination Details</h6>
    <div className='row'>
        <div className='col'>
        <SelectField fieldId="Field_132_nominee_relationship_type" fieldName="Relationship Type" fieldValue={additinalDetail.nomineeRelationshipType}  fieldPlaceholder="" fieldOptions={masterData.relationshipTypeModelList} 
        isMandatory={isFieldMandatory(uiFieldStore, 'Field_132_nominee_relationship_type')} isVisible={isFieldVisible(uiFieldStore, 'Field_132_nominee_relationship_type')} isEditable={isFieldEditable(uiFieldStore, 'Field_132_nominee_relationship_type')} />
        </div>
        
        <div className='col'>
        <TextField fieldId="Field_143_nominee_date_of_birth" fieldName="Date of Birth" fieldValue={additinalDetail.nomineeDateOfBirth} fieldPlaceholder="" 
        isMandatory={isFieldMandatory(uiFieldStore, 'Field_143_nominee_date_of_birth')} isVisible={isFieldVisible(uiFieldStore, 'Field_143_nominee_date_of_birth')} isEditable={isFieldEditable(uiFieldStore, 'Field_143_nominee_date_of_birth')} />
        </div>
    </div>
    <div className='row'>
        <div className='col'>
        <TextField fieldId="Field_133_nominee_first_name" fieldName="First Name" fieldValue={additinalDetail.nomineeFirstName} fieldPlaceholder="" 
        isMandatory={isFieldMandatory(uiFieldStore, 'Field_133_nominee_first_name')} isVisible={isFieldVisible(uiFieldStore, 'Field_133_nominee_first_name')} isEditable={isFieldEditable(uiFieldStore, 'Field_133_nominee_first_name')} />
        </div>
        
        <div className='col'>
        <TextField  fieldId="Field_134_nominee_last_name" fieldName="Last Name" fieldValue={additinalDetail.nomineeLastName} fieldPlaceholder="" 
        isMandatory={isFieldMandatory(uiFieldStore, 'Field_134_nominee_last_name')} isVisible={isFieldVisible(uiFieldStore, 'Field_134_nominee_last_name')} isEditable={isFieldEditable(uiFieldStore, 'Field_134_nominee_last_name')} />
        </div>
    </div>
    </div>
</div>
  )
}

export default AdditionalDetails