import React from 'react';
import RequestLayout from './../src/components/layouts/RequestLayout'
import './App.css';
import { BrowserRouter, Route, Routes } from 'react-router-dom'
import BasicDetails from './components/contents/BasicDetails';
import AddressDetails from './components/contents/AddressDetails';
import AdditionalDetails from './components/contents/AdditionalDetails'
import ProductDetails from './components/contents/ProductDetails';
import AuditDetails from './components/contents/AuditDetails';
import DocumentDetails from './components/contents/DocumentDetails';


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
          </Routes>
        </BrowserRouter> }
    </div>
  )
}

export default App;
