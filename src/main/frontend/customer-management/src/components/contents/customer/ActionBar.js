import React from 'react'
import { NavLink } from 'react-router-dom'

const ActionBar = () => {
  return (
    <div style={{ float: 'right' }}>
      <div class="dropdown">
        <button className='btn btn-primary' >Action</button>
        <div class="dropdown-content">
          <NavLink to="/search/request">Search Request</NavLink>
          <NavLink to="/search/customer">Search Customer</NavLink>
          <NavLink to="">Create Customer</NavLink>
        </div>
      </div>
    </div>



  )
}

export default ActionBar