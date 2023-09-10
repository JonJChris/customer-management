import React from 'react'
import RequestTabs from './RequestTabs'
import BasicDetails from '../contents/BasicDetails'

const RequestBody = () => {
  const tabItems = [
    { tabId: 1, tabName: "Basic Details", tabErrors: 0, isActive: true },
    { tabId: 2, tabName: "Address Details", tabErrors: 0, isActive: false },
    { tabId: 3, tabName: "Additional Details", tabErrors: 0, isActive: false },
    { tabId: 4, tabName: "Product Details", tabErrors: 0, isActive: false },
    { tabId: 5, tabName: "Document Details", tabErrors: 0, isActive: false },
    { tabId: 6, tabName: "Audit Details", tabErrors: 0, isActive: false },
  ]

  return (
    <div className='border border-rounded mt-2 p-2'>
      <RequestTabs tabItems={tabItems} />
      <div className="tab-content" id="myTabContent">
        <BasicDetails />
        
      </div>
    </div>
  )
}

export default RequestBody