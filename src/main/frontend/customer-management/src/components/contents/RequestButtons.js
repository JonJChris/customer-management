import React from 'react'

const RequestButtons = (props) => {
  return (
    <div className='border border-rounded mt-3 p-3'>
        <div className='row'>
            <div className='col-8'></div>
            <div className='col-2'><button className='btn btn-primary' name="Rework" onClick={props.submitRequest}>Reset Values</button></div>            
            <div className='col-2'><button className='btn btn-primary' name="Submit" onClick={props.submitRequest}>Save and Submit</button></div>            
        </div>
    </div>
  )
}

export default RequestButtons
