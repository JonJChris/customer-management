import React from 'react'
import PropTypes from 'prop-types'

const SelectField = (props) => {
  if (props.isVisible) {

  return (
    <div className='text-field row'>
            <div className='col text-field-label'>
                <label className='text-strong ' htmlFor={props.fieldId}>{props.fieldName}</label>
          { props.isMandatory && <span className='field-mandatory-indicator'>*</span>}
          </div>
          {props.isEditable ?
          <select id={props.fieldId} className="form-select col" value={props.fieldValue && props.fieldValue.key} onChange={props.fieldOnChange} name={props.fieldId}>
                <option key={1} value={""}>Select</option>
                {props.fieldOptions && props.fieldOptions.map( option => (
                  
                    <option  key={option.optionKey}  value={option.optionKey}>{option.optionValue}</option>
                  
                ))}
          </select>
      : <label className='text-strong col'>{props.fieldValue.value}</label>}
    </div>
  )
              }

}

SelectField.propTypes = {
  fieldId: PropTypes.string.isRequired,
  fieldName: PropTypes.string.isRequired,
  // fieldPlaceholder : PropTypes.string.isRequired,
  fieldOptions : PropTypes.array.isRequired
}


export default SelectField
