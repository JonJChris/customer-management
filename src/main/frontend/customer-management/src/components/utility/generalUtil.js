export const isFieldVisible = (uiFieldStore, fieldName) => {
    let returnVal  =false
  
    if(uiFieldStore && uiFieldStore.uiFields && uiFieldStore.uiFields[fieldName] && uiFieldStore.uiFields[fieldName].isVisible){
      returnVal = true
    } 
    return returnVal;
  }

  export const isFieldEditable =  (uiFieldStore, fieldName) => {
    let returnVal  =false
  
    if(uiFieldStore && uiFieldStore.uiFields && uiFieldStore.uiFields[fieldName] && uiFieldStore.uiFields[fieldName].isEditable){
      returnVal = true
    } 
    return returnVal;
  }

export   const isFieldMandatory =  (uiFieldStore, fieldName) => {
    let returnVal  =false
  
    if(uiFieldStore && uiFieldStore.uiFields && uiFieldStore.uiFields[fieldName] && uiFieldStore.uiFields[fieldName].isMandatory){
      returnVal = true
    } 
    return returnVal;
  }
  export   const getFieldMaxLength =  (uiFieldStore, fieldName) => {
    let returnVal  = 0
  
    if(uiFieldStore && uiFieldStore.uiFields && uiFieldStore.uiFields[fieldName]){
      returnVal = uiFieldStore.uiFields[fieldName].maxLength
    } 
    return returnVal;
  }  