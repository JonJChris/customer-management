import React from 'react'
import profileImg from './../assets/profile.svg'
const TopNavigation = () => {


  return (

    <div className="my-navbar">
      <div className='row'>
        <button className='btn btn-primary col-3 btn-arrow-right' >Customer Management System</button>
        <div className='col-7'></div>
        <div className="my-dropdown col-1">
          <button className="btn btn-primary">Action </button>
          <div className="dropdown-content">
            <a href="#">Create Customer</a>
            <a href="#">Search Customer</a>
            <a href="#">Search Request</a>

          </div>
        </div>
        <div className='col-1 text-end'>
          <button className="btn btn-primary">
            <img src={profileImg} className='icon-svg' alt='profile' />
          </button>
        </div>
      </div>
    </div>

  )
}

export default TopNavigation