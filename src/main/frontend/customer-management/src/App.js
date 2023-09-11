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



const App = () => {

  return (
    <div className="App container">
        { <BrowserRouter>
          <Routes>
            <Route path="/request/:requestId" element={<RequestLayout />} >
              <Route path="basic" element={<RequestBasicDetails />} />
              <Route path="Address" element={<RequestAddressDetails />} />
              <Route path="Additional" element={<RequestAdditionalDetails />} />
              <Route path="Document" element={<RequestDocumentDetails />} />
              <Route path="Product" element={<RequestProductDetails />} />
            </Route>
            <Route path="/customer/:customerId" element={<CustomerLayout />} >
              <Route path="basic" element={<CustomerBasicDetails />} />
              <Route path="Address" element={<CustomerAddressDetails />} />
              <Route path="Additional" element={<CustomerAdditionalDetails />} />
              <Route path="Document" element={<CustomerDocumentDetails />} />
              <Route path="Product" element={<CustomerProductDetails />} />
            </Route>
            <Route path="/search/customer" element={<CustomerSearchLayout />} />
            <Route path="/search/request" element={<RequestSearchLayout />} />
            
          </Routes>
        </BrowserRouter> }
    </div>
  )
}

export default App;
