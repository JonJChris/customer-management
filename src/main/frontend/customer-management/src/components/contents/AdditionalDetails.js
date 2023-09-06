import React from 'react'
import TextField from '../elements/TextField'
import SelectField from '../elements/SelectField'
import {useSelector} from 'react-redux';

const AdditionalDetails = () => {
  const masterData = useSelector( state => state.masterDataSlice);
  return (
    <div className="tab-pane fade show active" id="home" role="tabpanel"  >
    <div className='m-2' >
    <h6 className='tab-section-title'></h6>
    <div className='row'>
        <div className='col'>
        <SelectField fieldId="126_educational_qualification" fieldName="Educational Qualification" fieldPlaceholder="" fieldOptions={masterData.educationLevelList} isMandatory={true} isVisible={true} isEditable={true}/>
        </div>
        <div className='col'>
        <SelectField  fieldId="127_occupation_type" fieldName="Occupation Type" fieldPlaceholder="" fieldOptions={masterData.professionList} isMandatory={true} isVisible={true} isEditable={true}/>
        </div>
    </div>
    
    <div className='row'>
        <div className='col'>
        <TextField fieldId="128_organisation_name" fieldName="Organisation Name" fieldPlaceholder="" isMandatory={true} isVisible={true} isEditable={true} />
        </div>
        <div className='col'>
        <TextField  fieldId="129_designation" fieldName="Designation" fieldPlaceholder="" isMandatory={true} isVisible={true} isEditable={true}/>
        </div>
    </div>
  
    <div className='row'>
        <div className='col'>
        <SelectField fieldId="130_yearly_income" fieldName="Yearly Income" fieldPlaceholder="" fieldOptions={masterData.yearlyIncomeList} isMandatory={true} isVisible={true} isEditable={true}/>
        </div>
        
        <div className='col'>
        <SelectField fieldId="142_home_ownership_type" fieldName="Home Ownership Type" fieldPlaceholder="" fieldOptions={masterData.homeOwnershipTypesList} isMandatory={true} isVisible={true} isEditable={true}/>
        </div>
    </div>
    <hr />
    <h6 className='tab-section-title'>Nomination Details</h6>
    <div className='row'>
        <div className='col'>
        <SelectField fieldId="132_nominee_relationship_type" fieldName="Relationship Type" fieldPlaceholder="" fieldOptions={masterData.relationshipTypesList} isMandatory={true} isVisible={true} isEditable={true}/>
        </div>
        
        <div className='col'>
        
        </div>
    </div>
    <div className='row'>
        <div className='col'>
        <TextField fieldId="133_nominee_first_name" fieldName="First Name" fieldPlaceholder="" isMandatory={true} isVisible={true} isEditable={true}/>
        </div>
        
        <div className='col'>
        <TextField  fieldId="134_nominee_last_name" fieldName="Last Name" fieldPlaceholder="" isMandatory={true} isVisible={true} isEditable={true}/>
        </div>
    </div>
    </div>
</div>
  )
}

export default AdditionalDetails