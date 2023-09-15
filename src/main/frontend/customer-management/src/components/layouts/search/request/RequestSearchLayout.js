import React, { useState, useEffect } from 'react'
import RequestSearchHead from '../../../contents/search/request/RequestSearchHead'
import RequestSearchResult from '../../../contents/search/request/RequestSearchResult'
import { postRequestAndThenCallBack, getRequestAndThenCallBack } from '../../../utility/api-util'
import { useDispatch, useSelector } from 'react-redux'
import { actions } from '../../../../store/master-data'
const RequestSearchLayout = () => {
 
  const masterData = useSelector(state => state.masterDataSlice);
  const dispatch = useDispatch();
  const [requestSearchResult, setRequestSearchResult] = useState( {message: "", requestItemList:[]});
  const [requestSearchData, setRequestSearchData] = useState({Field_153_search_request_id:'', 
                                                              Field_154_search_customer_first_name:'', 
                                                              Field_155_search_customer_last_name:'', 
                                                              Field_156_search_request_type:''})
  const updateSearchResult = (result) => {
    setRequestSearchResult(result);
  }

  const onChangeHandler = (evt) => {
    setRequestSearchData( (prevState) => {
      return {
        ...prevState,
        [evt.target.name] : evt.target.value
      }
    })
   
  }
  const onClickHandler = (evt) => {
    
    const url = "http://localhost:8080/api/search/request";
    const requestBody = {
      requestId: requestSearchData.Field_153_search_request_id,
      customerFirstName: requestSearchData.Field_154_search_customer_first_name,
      customerLastName: requestSearchData.Field_155_search_customer_last_name,
      requestType: requestSearchData.Field_156_search_request_type,
    }
    postRequestAndThenCallBack(url, requestBody, updateSearchResult);
  }
  const updateMasterDataInStore = (masterData) => {
    dispatch(actions.refreshMasterData(masterData));
  }

  useEffect(() => {
    if (!masterData.masterDataExists) {
      getRequestAndThenCallBack('http://localhost:8080/api/masterData/fetchAll', updateMasterDataInStore);
    }
    
  }, []);

  return (
    <div>


      <RequestSearchHead changeHandler={onChangeHandler} clickHandler={onClickHandler} {...requestSearchData}/>
      <RequestSearchResult searchResult={requestSearchResult.requestItemList} />
    </div>
  )
}

export default RequestSearchLayout