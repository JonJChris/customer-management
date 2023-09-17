import React from 'react'
import { NavLink } from 'react-router-dom'

const ActionBar = () => {
  return (
    <div style={{ float: 'right' }}>
      <div className="dropdown">
        <button className='btn btn-primary' >Action</button>
        <div className="dropdown-content">
          <NavLink to="/search/request">Search Request</NavLink>
          <NavLink to="/search/customer">Search Customer</NavLink>
          <NavLink to="">Create Customer</NavLink>
        </div>
      </div>
    </div>



  )
}

export default ActionBar