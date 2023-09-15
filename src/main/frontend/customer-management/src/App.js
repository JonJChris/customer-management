import React from 'react';

import './App.css';
import { BrowserRouter, Route, Routes } from 'react-router-dom'

import RequestLayout from './components/layouts/request/RequestLayout.js'
import RequestBasicDetails from './components/contents/request/RequestBasicDetails.js';
import RequestAddressDetails from './components/contents/request/RequestAddressDetails.js';
import RequestAdditionalDetails from './components/contents/request/RequestAdditionalDetails.js'
import RequestProductDetails from './components/contents/request/RequestProductDetails.js';
import RequestDocumentDetails from './components/contents/request/RequestDocumentDetails.js';

import CustomerLayout from './components/layouts/customer/CustomerLayout.js';
import CustomerBasicDetails from './components/contents/customer/CustomerBasicDetails.js';
import CustomerAddressDetails from './components/contents/customer/CustomerAddressDetails.js';
import CustomerAdditionalDetails from './components/contents/customer/CustomerAdditionalDetails.js'
import CustomerProductDetails from './components/contents/customer/CustomerProductDetails.js';
import CustomerDocumentDetails from './components/contents/customer/CustomerDocumentDetails.js';

import CustomerSearchLayout from './components/layouts/search/customer/CustomerSearchLayout';
import RequestSearchLayout from './components/layouts/search/request/RequestSearchLayout.js';
import ErrorPage from './components/contents/common/ErrorPage';
import CreateNewCustomer from './components/contents/request/CreateNewCustomer';
import AppLayout from './components/layouts/AppLayout';
import { Home } from './components/contents/home/Home';



const App = () => {

  return (
    <div className="App container">
      {<BrowserRouter>
        <Routes>
          <Route exact path="/" element={<AppLayout />}>
          <Route index element={<Home />} />
            <Route exact path="request/:requestId" element={<RequestLayout />} >
              <Route exact path="basic" element={<RequestBasicDetails />} />
              <Route exact path="Address" element={<RequestAddressDetails />} />
              <Route exact path="Additional" element={<RequestAdditionalDetails />} />
              <Route exact path="Document" element={<RequestDocumentDetails />} />
              <Route exact path="Product" element={<RequestProductDetails />} />
            </Route>
            <Route exact path="/customer/:customerId" element={<CustomerLayout />} >
              <Route exact path="basic" element={<CustomerBasicDetails />} />
              <Route exact path="Address" element={<CustomerAddressDetails />} />
              <Route exact path="Additional" element={<CustomerAdditionalDetails />} />
              <Route exact path="Document" element={<CustomerDocumentDetails />} />
              <Route exact path="Product" element={<CustomerProductDetails />} />
            </Route>
            <Route exact path="search/customer" element={<CustomerSearchLayout />} />
            <Route exact path="search/request" element={<RequestSearchLayout />} />
            <Route exact path="request/createNewCustomer" element={<CreateNewCustomer />} />
            <Route exact path="*" element={<ErrorPage />} />

          </Route>


        </Routes>
      </BrowserRouter>}
    </div>
  )
}

export default App;
