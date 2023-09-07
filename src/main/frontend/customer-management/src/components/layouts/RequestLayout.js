import React, { useEffect, useState } from 'react'
import RequestHead from '../contents/RequestHead'
import TopNavigation from '../TopNavigation'
import RequestButtons from '../contents/RequestButtons'
import RequestTabs from './../layouts/RequestTabs'
import { Outlet, useParams } from 'react-router-dom'
import { useDispatch, useSelector } from 'react-redux'
import { actions } from './../../store/master-data'
import { actions as uiFieldActions} from './../../store/ui-field-store'
import { updateRequestHeadDetails, updateAdditionalDetails, updateAddressDetails, updateBasicDetails } from './../functions/updateStateFromModel'

const RequestLayout = () => {
  const tabItems = [
    { tabId: '137_basic_details_tab', tabName: "Basic Details", tabErrors: 0, isActive: true, tabLink: './basic' },
    { tabId: '138_address_details_tab', tabName: "Address Details", tabErrors: 0, isActive: false, tabLink: 'Address' },
    { tabId: '139_additional_details_tab', tabName: "Additional Details", tabErrors: 0, isActive: false, tabLink: 'Additional' },
    { tabId: '140_product_details_tab', tabName: "Product Details", tabErrors: 0, isActive: false, tabLink: 'Product' },
    { tabId: '141_document_details_tab', tabName: "Document Details", tabErrors: 0, isActive: false, tabLink: 'Document' },
  ]
  const dispatch = useDispatch();
  const masterData = useSelector(state => state.masterDataSlice);
  const params = useParams();
  const [requestHeadDetails, setRequestHeadDetails] = useState({ requestId: 0, requestType: 0, requestCreated: '', requestStage: 0 })
  const [basicDetails, setBasicDetails] = useState({ customerId: 0, userTitle: 0, firstName: '', lastName: '', displayName: '', nationality: 0, email: '', dateOfBirth: '', maritalStatus: 0, customerType: 0 })
  const [addressDetails, setAddressDetails] = useState({ addressId: 0, registeredAddressLine1: "", registeredAddressLine2: "", registeredAddressCity: "", registeredAddressState: "", registeredAddressCountry: 0, registeredAddressPostalCode: "", communicationAddressLine1: "", communicationAddressLine2: "", communicationAddressCity: "", communicationAddressState: "", communicationAddressCountry: 0, communicationAddressPostalCode: "" })
  const [additionalDetails, setAdditionalDetails] = useState({ customerEducationLevel: 0, customerProfession: 0, customerOrganisationName: "", customerYearlyIncome: "", homeOwnershipType: 0, nomineeRelationshipType: 0, nomineeFirstName: "", nomineeLastName: "", nomineeDateOfBirth: "" })
  


  const fetchAndThenCallBack = async (url, callbackFunc) => {
      try{
        const resp = await fetch(url);
        if (!resp.ok){
          throw new Error("Error while fetching from url "+url)
        }
        const data = await resp.json();
        callbackFunc(data);
      }catch(error){
        console.log(error.message);
      }
  }

  const updateMasterDataInStore = (masterData) => {
    dispatch(actions.refreshMasterData(masterData));
  }
  const updateRequesPageState = (requestDetails) => {
    updateRequestHeadDetails(requestDetails, setRequestHeadDetails);
    updateBasicDetails(requestDetails, setBasicDetails);
    updateAddressDetails(requestDetails, setAddressDetails);
    updateAdditionalDetails(requestDetails, setAdditionalDetails);
    dispatch(uiFieldActions.updateUIFields(requestDetails.uiFieldModelsList));
  }


  useEffect(() => {
    if (!masterData.masterDataExists) {
      fetchAndThenCallBack('http://localhost:8080/api/masterData/fetchAll', updateMasterDataInStore);
    }

    if (params.requestId) {
      fetchAndThenCallBack(`http://localhost:8080/api/request/${params.requestId}`, updateRequesPageState);
    }

  }, []);


  return (
    <div>

      <TopNavigation />
      <form>
        <RequestHead {...requestHeadDetails} />

        <div className='border border-rounded mt-2 p-2'>
          <RequestTabs tabItems={tabItems} />
          <div className="tab-content" id="myTabContent">
            <Outlet context={{ basicDetails, addressDetails, additionalDetails }} />
          </div>
        </div>

        <RequestButtons />
      </form>
    </div>
  )
}


export default RequestLayout




