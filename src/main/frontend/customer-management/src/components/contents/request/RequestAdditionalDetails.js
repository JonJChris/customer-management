import React from 'react'
import TextField from '../../elements/TextField'
import SelectField from '../../elements/SelectField'
import {useSelector} from 'react-redux';
import { useOutletContext } from 'react-router-dom';
import {isFieldEditable, isFieldMandatory, isFieldVisible, getFieldMaxLength} from '../../utility/generalUtil'
import DateField from '../../elements/DateField';

const RequestAdditionalDetails = () => {
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
        <SelectField fieldId="Field_126_educational_qualification" fieldName="Educational Qualification" fieldValue={additionalDetail.Field_126_educational_qualification} fieldPlaceholder=""  fieldOptions={masterData.educationLevelsList} 
        isMandatory={isFieldMandatory(uiFieldStore, 'Field_126_educational_qualification')} isVisible={isFieldVisible(uiFieldStore, 'Field_126_educational_qualification')} isEditable={context.stageEditable && isFieldEditable(uiFieldStore, 'Field_126_educational_qualification')} 
        fieldOnChange={context.updateStateForAdditionalTab}/>
        </div>
        <div className='col'>
        <SelectField  fieldId="Field_127_occupation_type" fieldName="Occupation Type" fieldValue={additionalDetail.Field_127_occupation_type} fieldPlaceholder="" fieldOptions={masterData.professionModelList} 
        isMandatory={isFieldMandatory(uiFieldStore, 'Field_127_occupation_type')} isVisible={isFieldVisible(uiFieldStore, 'Field_127_occupation_type')} isEditable={context.stageEditable && isFieldEditable(uiFieldStore, 'Field_127_occupation_type')} 
        fieldOnChange={context.updateStateForAdditionalTab}/>
        </div>
    </div>
    
    <div className='row row-standard'>
        <div className='col'>
        <TextField fieldId="Field_128_organisation_name" fieldName="Organisation Name" fieldValue={additionalDetail.Field_128_organisation_name} fieldPlaceholder="" 
        isMandatory={isFieldMandatory(uiFieldStore, 'Field_128_organisation_name')} isVisible={isFieldVisible(uiFieldStore, 'Field_128_organisation_name')} isEditable={context.stageEditable && isFieldEditable(uiFieldStore, 'Field_128_organisation_name')} 
        fieldOnChange={context.updateStateForAdditionalTab} fieldMaxLength={getFieldMaxLength(uiFieldStore, 'Field_128_organisation_name')}/>
        </div>
        <div className='col'>
        {/* <TextField  fieldId="129_designation" fieldName="Designation" fieldValue={} fieldPlaceholder="" 
        isMandatory={isFieldMandatory(uiFieldStore, '129_designation')} isVisible={isFieldVisible(uiFieldStore, '129_designation')} isEditable={isFieldEditable(uiFieldStore, '129_designation')} /> */}
        </div>
    </div>
  
    <div className='row row-standard'>
        <div className='col'>
        <SelectField fieldId="Field_130_yearly_income" fieldName="Yearly Income" fieldValue={additionalDetail.Field_130_yearly_income} fieldPlaceholder="" fieldOptions={masterData.yearlyIncomeModelList} 
        isMandatory={isFieldMandatory(uiFieldStore, 'Field_130_yearly_income')} isVisible={isFieldVisible(uiFieldStore, 'Field_130_yearly_income')} isEditable={context.stageEditable && isFieldEditable(uiFieldStore, 'Field_130_yearly_income')} 
        fieldOnChange={context.updateStateForAdditionalTab}/>
        </div>
        
        <div className='col'>
        <SelectField fieldId="Field_142_home_ownership_type" fieldName="Home Ownership Type" fieldValue={additionalDetail.Field_142_home_ownership_type} fieldPlaceholder="" fieldOptions={masterData.homeOwnershipTypeModelList} 
        isMandatory={isFieldMandatory(uiFieldStore, 'Field_142_home_ownership_type')} isVisible={isFieldVisible(uiFieldStore, 'Field_142_home_ownership_type')} isEditable={context.stageEditable && isFieldEditable(uiFieldStore, 'Field_142_home_ownership_type')} 
        fieldOnChange={context.updateStateForAdditionalTab}/>
        </div>
    </div>
    <hr />
    <h6 className='tab-section-title'>Nomination Details</h6>
    <div className='row row-standard'>
        <div className='col'>
        <SelectField fieldId="Field_132_nominee_relationship_type" fieldName="Relationship Type" fieldValue={additionalDetail.Field_132_nominee_relationship_type}  fieldPlaceholder="" fieldOptions={masterData.relationshipTypeModelList} 
        isMandatory={isFieldMandatory(uiFieldStore, 'Field_132_nominee_relationship_type')} isVisible={isFieldVisible(uiFieldStore, 'Field_132_nominee_relationship_type')} isEditable={context.stageEditable && isFieldEditable(uiFieldStore, 'Field_132_nominee_relationship_type')} 
        fieldOnChange={context.updateStateForAdditionalTab}/>
        </div>
        
        <div className='col'>
        <DateField fieldId="Field_143_nominee_date_of_birth" fieldName="Date of Birth" fieldValue={additionalDetail.Field_143_nominee_date_of_birth} fieldPlaceholder="" 
        isMandatory={isFieldMandatory(uiFieldStore, 'Field_143_nominee_date_of_birth')} isVisible={isFieldVisible(uiFieldStore, 'Field_143_nominee_date_of_birth')} isEditable={context.stageEditable && isFieldEditable(uiFieldStore, 'Field_143_nominee_date_of_birth')} 
        fieldOnChange={context.updateStateForAdditionalTab}/>
        </div>
    </div>
    <div className='row row-standard'>
        <div className='col'>
        <TextField fieldId="Field_133_nominee_first_name" fieldName="First Name" fieldValue={additionalDetail.Field_133_nominee_first_name} fieldPlaceholder="" 
        isMandatory={isFieldMandatory(uiFieldStore, 'Field_133_nominee_first_name')} isVisible={isFieldVisible(uiFieldStore, 'Field_133_nominee_first_name')} isEditable={context.stageEditable && isFieldEditable(uiFieldStore, 'Field_133_nominee_first_name')} 
        fieldOnChange={context.updateStateForAdditionalTab} fieldMaxLength={getFieldMaxLength(uiFieldStore, 'Field_133_nominee_first_name')}/>
        </div>
        
        <div className='col'>
        <TextField  fieldId="Field_134_nominee_last_name" fieldName="Last Name" fieldValue={additionalDetail.Field_134_nominee_last_name} fieldPlaceholder="" 
        isMandatory={isFieldMandatory(uiFieldStore, 'Field_134_nominee_last_name')} isVisible={isFieldVisible(uiFieldStore, 'Field_134_nominee_last_name')} isEditable={context.stageEditable && isFieldEditable(uiFieldStore, 'Field_134_nominee_last_name')} 
        fieldOnChange={context.updateStateForAdditionalTab} fieldMaxLength={getFieldMaxLength(uiFieldStore, 'Field_134_nominee_last_name')}/>
        </div>
    </div>
    </div>
</div>
  )
}

export default RequestAdditionalDetails