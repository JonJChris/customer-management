import React from 'react';
import RequestLayout from './components/layouts/request/RequestLayout.js'
import './App.css';
import { BrowserRouter, Route, Routes } from 'react-router-dom'
import BasicDetails from './components/contents/common/BasicDetails';
import AddressDetails from './components/contents/common/AddressDetails';
import AdditionalDetails from './components/contents/common/AdditionalDetails'
import ProductDetails from './components/contents/common/ProductDetails';
import AuditDetails from './components/contents/common/AuditDetails';
import DocumentDetails from './components/contents/common/DocumentDetails';
import CustomerSearchLayout from './components/layouts/search/customer/CustomerSearchLayout';


const App = () => {

  return (
    <div className="App container">
        { <BrowserRouter>
          <Routes>
            <Route path="/request/:requestId" element={<RequestLayout />} >
              <Route path="basic" element={<BasicDetails />} />
              <Route path="Address" element={<AddressDetails />} />
              <Route path="Additional" element={<AdditionalDetails />} />
              <Route path="Document" element={<DocumentDetails />} />
              <Route path="Product" element={<ProductDetails />} />
              <Route path="Audit" element={<AuditDetails />} />
            </Route>
            <Route path="/search/customer" element={<CustomerSearchLayout />} >
            </Route> 
          </Routes>
        </BrowserRouter> }
    </div>
  )
}

export default App;
