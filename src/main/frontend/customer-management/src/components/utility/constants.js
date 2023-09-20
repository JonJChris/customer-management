export const NEW_REQUEST_NEW_CUSTOMER = 'Create New Customer';
export const NEW_REQUEST_ADDRESS_AMENDMENT = 'Address Amendment';
export const NEW_REQUEST_KYC_AMENDMENT = 'KYC Amendment';
export const NEW_REQUEST_PRODUCT_AMENDMENT = 'Product Amendment';
export const NEW_REQUEST_DOCUMENT_AMENDMENT = 'Document Amendment';
export const NEW_REQUEST_PERIODIC_REVIEW = 'Periodic Review';
export const NEW_REQUEST_LIFECYCLE_REQUEST = 'Customer Lifecycle Request';

// export const API_URL_CREATE_REQUEST = 'http://localhost:8080/api/request/new'
export const API_CALL_BASE_URL = 'http://localhost:8080/api'

export const getRequestURL = () => {
    const reqPort = window.location.port ? ':8080' : '';
    const reqProtocol = window.location.protocol+ '//'
    return reqProtocol + window.location.hostname + reqPort +'/api'
  
  }
