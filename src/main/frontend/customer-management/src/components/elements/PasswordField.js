import React from 'react'



const PasswordField = (props) => {

  if (props.isVisible) {
    return (
      <div className='text-field row'>
        <div className='col text-field-label'>
          <label className='text-strong ' htmlFor={props.fieldId}>{props.fieldName}</label>
          {props.isMandatory && <span className='field-mandatory-indicator'>*</span>}
        </div>
        {props.isEditable
          ? <input type="password" id={props.fieldId} name={props.fieldId} className="col form-control text-field-input" placeholder={props.fieldPlaceholder} 
            value={props.fieldValue}
          onChange={props.fieldOnChange}
          maxLength={props.fieldMaxLength}
          />
          : <label className='text-strong col'>{props.fieldValue}</label>
        }


      </div>
    )
  } else {
    return <span></span>
  }


}



export default PasswordField