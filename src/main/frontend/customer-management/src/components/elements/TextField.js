import React from 'react'
import PropTypes from 'prop-types'


const TextField = (props) => {

  if (props.isVisible) {
    return (
      <div className='text-field row'>
        <div className='col text-field-label'>
          <label className='text-strong ' htmlFor={props.fieldId}>{props.fieldName}</label>
          {props.isMandatory && <span className='field-mandatory-indicator'>*</span>}
        </div>
        {props.isEditable
          ? <input type="text" id={props.fieldId} name={props.fieldId} className="col form-control text-field-input" placeholder={props.fieldPlaceholder}  value={props.fieldValue}/>
          : <label className='text-strong col'>{props.fieldValue}</label>
        }


      </div>
    )
  } else {
    return <span></span>
  }


}



TextField.propTypes = {
  fieldId: PropTypes.string.isRequired,
  fieldName: PropTypes.string.isRequired,
  // fieldPlaceholder: PropTypes.string.isRequired,
}
export default TextField