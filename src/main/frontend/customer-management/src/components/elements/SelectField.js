import React from 'react'
import PropTypes from 'prop-types'

const SelectField = (props) => {
  return (
    <div className='text-field row'>
            <div className='col text-field-label'>
                <label className='text-strong ' htmlFor={props.fieldId}>{props.fieldName}</label>
                { props.isMandatory && <span className='field-mandatory-indicator'>*</span>}
          </div>
          <select id={props.fieldId} className="form-select col">
                {props.fieldOptions && props.fieldOptions.map( option => (
                    <option key={option.optionKey} value={option.optionKey}>{option.optionValue}</option>
                ))}
          </select>
         
    </div>
  )
}

SelectField.propTypes = {
  fieldId: PropTypes.string.isRequired,
  fieldName: PropTypes.string.isRequired,
  // fieldPlaceholder : PropTypes.string.isRequired,
  fieldOptions : PropTypes.array.isRequired
}


export default SelectField
