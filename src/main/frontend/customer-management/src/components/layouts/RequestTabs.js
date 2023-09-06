import React from 'react'
import { NavLink } from 'react-router-dom'
const RequestTabs = (props) => {
  return (
    <div>
      <div className=''>
        <ul className="nav nav-tabs">

          {props.tabItems.map(tabItem => (
            <li key={tabItem.tabId} className="nav-item">
              <NavLink className={`nav-link   ${ (obj) => obj.isActive && 'active'}`} to={tabItem.tabLink}>{tabItem.tabName}</NavLink>
            </li>
          ))}

        </ul>
      </div>

    </div>
  )
}

export default RequestTabs