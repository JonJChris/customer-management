import React, { useState, useEffect } from 'react'
import SearchHead from '../../../contents/search/CustomerSearchHead'
import { Outlet } from 'react-router-dom'
import TopNavigation from '../../../TopNavigation'
import CustomerSearchResult from '../../../contents/search/CustomerSearchResult'
import { postRequestAndThenCallBack, getRequestAndThenCallBack } from '../../../utility/api-util'
import { useDispatch, useSelector } from 'react-redux'
import { actions } from './../../../../store/master-data'
const CustomerSearchLayout = () => {
 
  const masterData = useSelector(state => state.masterDataSlice);
  const dispatch = useDispatch();
  const [customerSearchResult, setCustomerSearchResult] = useState( {message: "", customerItemList:[]});
  const [customerSearchData, setCustomerSearchData] = useState({Field_147_search_customer_id:'', 
                                                                Field_148_search_customer_first_name:'', 
                                                                Field_149_search_customer_last_name:'', 
                                                                Field_150_search_customer_nationality:''})
  const updateSearchResult = (result) => {
    setCustomerSearchResult(result);
  }

  const onChangeHandler = (evt) => {
    setCustomerSearchData( (prevState) => {
      return {
        ...prevState,
        [evt.target.name] : evt.target.value
      }
    })
   
  }
  const onClickHandler = (evt) => {
    console.log("Button Clicked");
    const url = "http://localhost:8080/api/search/customer";
    const requestBody = {
      customerId: customerSearchData.Field_147_search_customer_id,
      firstName: customerSearchData.Field_148_search_customer_first_name,
      lastName: customerSearchData.Field_149_search_customer_last_name,
      nationality: customerSearchData.Field_150_search_customer_nationality,
    }
    postRequestAndThenCallBack(url, requestBody, updateSearchResult);
  }
  const updateMasterDataInStore = (masterData) => {
    console.log(masterData)
    dispatch(actions.refreshMasterData(masterData));
  }

  useEffect(() => {
    if (!masterData.masterDataExists) {
      getRequestAndThenCallBack('http://localhost:8080/api/masterData/fetchAll', updateMasterDataInStore);
    }
    // const url = "http://localhost:8080/api/search/customer";
    // const requestBody = {
    //   "customerId": "100001",
    //   "firstName": "John",
    //   "lastName": "Wick",
    //   "Nationality": "Afghanistan"
    // }
    // console.log("URL : " + url);
    // postRequestAndThenCallBack(url, requestBody, updateSearchResult);
  }, []);

  return (
    <div>

      <TopNavigation />
      <SearchHead changeHandler={onChangeHandler} clickHandler={onClickHandler} {...customerSearchData}/>
      <CustomerSearchResult searchResult={customerSearchResult.customerItemList} />
    </div>
  )
}

export default CustomerSearchLayout