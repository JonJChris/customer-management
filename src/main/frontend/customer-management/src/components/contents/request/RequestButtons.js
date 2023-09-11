import React from 'react'

const RequestButtons = (props) => {
  return (
    <div className='border border-rounded mt-3 p-3'>
        <div className='row'>
            <div className='col-8'></div>
            
            <div className='col-2'><button className='btn btn-primary' 
            name="Field_146_request_rework" onClick={props.fieldOnSubmit}>Reset Values</button></div>            
            
            <div className='col-2'><button className='btn btn-primary' 
            name="Field_145_request_submit" onClick={props.fieldOnSubmit}>Save and Submit</button></div>            
        </div>
    </div>
  )
}

export default RequestButtons
