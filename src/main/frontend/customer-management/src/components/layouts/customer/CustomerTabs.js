import React from 'react'
import { NavLink } from 'react-router-dom'
import {useSelector} from 'react-redux'
const RequestTabs = (props) => {
  const uiData = useSelector(state => state.UIFieldStoreSlice);
  return (
    <div>
      <div className=''>
        <ul className="nav nav-tabs">

          {props.tabItems && props.tabItems.map(tabItem => (
            <li key={tabItem.fieldName} className="nav-item">
              <NavLink className={`nav-link   ${ (obj) => obj.isActive && 'active'}`} to={tabItem.fieldLink}>{tabItem.fieldDisplayName}</NavLink>
            </li>
          ))}

        </ul>
      </div>

    </div>
  )
}

export default RequestTabs