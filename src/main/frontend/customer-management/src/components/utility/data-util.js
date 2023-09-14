
export const updateRequestHeadDetails = (requestDetails, setStateFunc) => {
  if (requestDetails) {
    setStateFunc((prevState) => {
      return {
        ...prevState,
        Field_100_request_id: requestDetails.requestId,
        Field_102_request_type: requestDetails.requestType && { key: requestDetails.requestType.requestTypeId, value: requestDetails.requestType.requestTypeName },
        Field_101_request_created: requestDetails.createdDate,
        Field_103_request_status: requestDetails.currentRequestStage && { key: requestDetails.currentRequestStage.stageId, value: requestDetails.currentRequestStage.stageName },
      }
    });
  }
}

export const updateRequestBasicDetails = (requestDetails, setStateFunc) => {
  if (requestDetails && requestDetails.customerModel) {
    const model = requestDetails.customerModel
    setStateFunc((prevState) => {
      return {
        ...prevState,
        Field_104_customer_id: model.customerId,
        Field_105_customer_title: model.userTitle && { key: model.userTitle.titleId, value: model.userTitle.titleName },
        Field_106_customer_first_name: model.firstName,
        Field_107_customer_last_name: model.lastName,
        Field_108_customer_display_name: model.displayName,
        Field_109_customer_nationality: model.nationality && { key: model.nationality.countryId, value: model.nationality.countryName },
        Field_110_customer_date_of_birth: model.dateOfBirth,
        Field_112_customer_marital_status: model.maritalStatus && { key: model.maritalStatus.maritalStatusId, value: model.maritalStatus.maritalStatusName },
        Field_113_customer_type: model.customerType && { key: model.customerType.customerTypeId, value: model.customerType.customerTypeName },
        Field_144_customer_email: model.email,
      }
    });
  }
}

export const updateRequestAddressDetails = (requestDetails, setStateFunc) => {
  if (requestDetails && requestDetails.addressModel) {
    const model = requestDetails.addressModel
    setStateFunc((prevState) => {
      return {
        ...prevState,

        addressId: model.addressId,
        Field_114_reg_address_line1: model.registeredAddressLine1,
        Field_115_reg_address_line2: model.registeredAddressLine2,
        Field_116_reg_address_city: model.registeredAddressCity,
        Field_117_reg_address_state: model.registeredAddressState,
        Field_118_reg_address_country: model.registeredAddressCountry && { key: model.registeredAddressCountry.countryId, value: model.registeredAddressCountry.countryName },
        Field_119_reg_address_postal_code: model.registeredAddressPostalCode,
        Field_120_com_address_line1: model.communicationAddressLine1,
        Field_121_com_address_line2: model.communicationAddressLine2,
        Field_122_com_address_city: model.communicationAddressCity,
        Field_123_com_address_state: model.communicationAddressState,
        Field_124_com_address_country: model.communicationAddressCountry && { key: model.communicationAddressCountry.countryId, value: model.communicationAddressCountry.countryName },
        Field_125_com_address_postal_code: model.communicationAddressPostalCode,
      }
    });
  }
}

export const updateRequestAdditionalDetails = (requestDetails, setStateFunc) => {
  if (requestDetails && requestDetails.customerModel) {
    const model = requestDetails.customerModel
    setStateFunc((prevState) => {
      return {
        ...prevState,

        Field_126_educational_qualification: model.customerEducationLevel && { key: model.customerEducationLevel.educationLevelId, value: model.customerEducationLevel.educationLevelName },
        Field_127_occupation_type: model.customerProfession && { key: model.customerProfession.professionId, value: model.customerProfession.professionName },
        Field_128_organisation_name: model.customerOrganisationName,
        Field_130_yearly_income: model.customerYearlyIncome && { key: model.customerYearlyIncome.yearlyIncomeId, value: model.customerYearlyIncome.yearlyIncomeName },
        Field_143_nominee_date_of_birth: model.homeOwnershipType && { key: model.homeOwnershipType.homeOwnershipTypeId, value: model.homeOwnershipType.homeOwnershipTypeName },
        Field_132_nominee_relationship_type: model.nomineeRelationshipType && { key: model.nomineeRelationshipType.relationshipTypeId, value: model.nomineeRelationshipType.relationshipTypeName },
        Field_133_nominee_first_name: model.nomineeFirstName,
        Field_134_nominee_last_name: model.nomineeLastName,
        Field_143_nominee_date_of_birth: model.nomineeDateOfBirth
      }
    });
  }
}
export const updateProductDetails = (requestDetails, setStateFunc) => {
  if (requestDetails) {
    setStateFunc((prevState) => {
      return {
        productsList: requestDetails.productRelationshipModelList.map(item => {
          return {
            id: item.id,
            productStoreId: item.productStoreId,
            accountId: item.accountId,
            createdDate: item.createdDate,
            productType: {
              productTypeId: item.productType.productTypeId,
              productTypeName: item.productType.productTypeName,
            },
            productBranch: {
              branchTypeId: item.productBranch.branchTypeId,
              branchTypeName: item.productBranch.branchTypeName,
            }
          }
        })
      }
    });
  }
}
export const updateDocumentDetails = (requestDetails, setStateFunc) => {
  if (requestDetails) {
    setStateFunc((prevState) => {
      return {
        documentsList: requestDetails.documentModelList.map(item => {
          return {
            id: item.id,
            documentStoreId: item.documentStoreId,
            documentLinkPath: item.documentLinkPath,
            createdDate: item.createdDate,
            documentType: {
              documentTypeId: item.documentType.documentTypeId,
              documentTypeName: item.documentType.documentTypeName,
            }
          }
        })
      }
    });
  }
}
export const updateStageRibbonDetails = (requestDetails, setStateFunc) => {
  if (requestDetails) {
    setStateFunc((prevState) => {
      return {
        stagesList: requestDetails.allRequestStagesList.map(item => {
          return {
            id: item.id,
            stageTypeModel: {
              stageId: item.stageTypeModel.stageId,
              stageName: item.stageTypeModel.stageName,
            },
            statusTypeModel: {
              statusTypeId: item.statusTypeModel.statusTypeId,
              statusTypeName: item.statusTypeModel.statusTypeName,
            }
          }
        })
      }
    });
  }
}


export const buildRequestBody = (requestHeadDetails, basicDetails, addressDetails, additionalDetails, productDetails, documentDetails, userDetail) => {
  const requestBody = { customerModel: {}, addressModel: {} }

  requestBody['requestId'] = requestHeadDetails.Field_100_request_id;
  requestBody['requestType'] = requestHeadDetails.Field_102_request_type && { requestTypeId: requestHeadDetails.Field_102_request_type.key, requestTypeName: requestHeadDetails.Field_102_request_type.value };
  requestBody['requestStage'] = requestHeadDetails.Field_103_request_status && { requestStageId: requestHeadDetails.Field_103_request_status.key, requestStageName: requestHeadDetails.Field_103_request_status.value };
  requestBody['requestCreateDate'] = requestHeadDetails.Field_101_request_created;

  requestBody.customerModel['customerId'] = basicDetails.Field_104_customer_id;
  requestBody.customerModel['userTitle'] = basicDetails.Field_105_customer_title && { titleId: basicDetails.Field_105_customer_title.key, titleName: basicDetails.Field_105_customer_title.value };
  requestBody.customerModel['firstName'] = basicDetails.Field_106_customer_first_name;
  requestBody.customerModel['lastName'] = basicDetails.Field_107_customer_last_name;
  requestBody.customerModel['displayName'] = basicDetails.Field_108_customer_display_name;
  requestBody.customerModel['nationality'] = basicDetails.Field_109_customer_nationality && { countryId: basicDetails.Field_109_customer_nationality.key, countryName: basicDetails.Field_109_customer_nationality.value };
  requestBody.customerModel['email'] = basicDetails.Field_144_customer_email;
  requestBody.customerModel['dateOfBirth'] = basicDetails.Field_110_customer_date_of_birth;
  requestBody.customerModel['maritalStatus'] = basicDetails.Field_112_customer_marital_status && { maritalStatusId: basicDetails.Field_112_customer_marital_status.key, maritalStatusName: basicDetails.Field_112_customer_marital_status.value };
  requestBody.customerModel['customerType'] = basicDetails.Field_113_customer_type && { customerTypeId: basicDetails.Field_113_customer_type.key, customerTypeName: basicDetails.Field_113_customer_type.value };
  requestBody.customerModel['customerEducationLevel'] = additionalDetails.Field_126_educational_qualification && { educationLevelId: additionalDetails.Field_126_educational_qualification.key, educationLevelName: additionalDetails.Field_126_educational_qualification.value };
  requestBody.customerModel['customerProfession'] = additionalDetails.Field_127_occupation_type && { professionId: additionalDetails.Field_127_occupation_type.key, professionName: additionalDetails.Field_127_occupation_type.value };
  requestBody.customerModel['customerOrganisationName'] = additionalDetails.Field_128_organisation_name;
  requestBody.customerModel['customerYearlyIncome'] = additionalDetails.Field_130_yearly_income && { yearlyIncomeId: additionalDetails.Field_130_yearly_income.key, yearlyIncomeName: additionalDetails.Field_130_yearly_income.value };
  requestBody.customerModel['nomineeRelationshipType'] = additionalDetails.Field_132_nominee_relationship_type && { relationshipTypeId: additionalDetails.Field_132_nominee_relationship_type.key, relationshipTypeName: additionalDetails.Field_132_nominee_relationship_type.value };
  requestBody.customerModel['nomineeFirstName'] = additionalDetails.Field_133_nominee_first_name;
  requestBody.customerModel['nomineeLastName'] = additionalDetails.Field_134_nominee_last_name;
  requestBody.customerModel['nomineeDateOfBirth'] = additionalDetails.Field_143_nominee_date_of_birth;

  requestBody.addressModel['addressId'] = addressDetails.addressId;
  requestBody.addressModel['registeredAddressLine1'] = addressDetails.Field_114_reg_address_line1;
  requestBody.addressModel['registeredAddressLine2'] = addressDetails.Field_115_reg_address_line2;
  requestBody.addressModel['registeredAddressCity'] = addressDetails.Field_116_reg_address_city;
  requestBody.addressModel['registeredAddressState'] = addressDetails.Field_117_reg_address_state;
  requestBody.addressModel['registeredAddressCountry'] = addressDetails.Field_118_reg_address_country && { countryId: addressDetails.Field_118_reg_address_country.key, countryName: addressDetails.Field_118_reg_address_country.value };
  requestBody.addressModel['registeredAddressPostalCode'] = addressDetails.Field_119_reg_address_postal_code;

  requestBody.addressModel['communicationAddressLine1'] = addressDetails.Field_120_com_address_line1;
  requestBody.addressModel['communicationAddressLine2'] = addressDetails.Field_121_com_address_line2;
  requestBody.addressModel['communicationAddressCity'] = addressDetails.Field_122_com_address_city;
  requestBody.addressModel['communicationAddressState'] = addressDetails.Field_123_com_address_state;
  requestBody.addressModel['communicationAddressCountry'] = addressDetails.Field_124_com_address_country && { countryId: addressDetails.Field_124_com_address_country.key, countryName: addressDetails.Field_124_com_address_country.value };
  requestBody.addressModel['communicationAddressPostalCode'] = addressDetails.Field_125_com_address_postal_code;

  console.log(JSON.stringify(productDetails.productsList))
  requestBody.productRelationshipModelList = productDetails.productsList.map(item => (
    {
      ...item,
      id: item.id && String(item.id).includes('TEMP_') ? 0 : item.id
    }
  ));


  requestBody.documentModelList = documentDetails.documentsList;

  requestBody['requestSubmittedBy'] = {
    userId: userDetail.userId,
    username: userDetail.username,
    userFirstName: userDetail.userFirstName,
    userLastName: userDetail.userLastName
  }


  return requestBody;

}

export const updateCustomerHeadDetails = (customerDetails, setStateFunc) => {
  if (customerDetails) {
    setStateFunc((prevState) => {
      return {
        ...prevState,
        Field_197_customer_crated_date: customerDetails.createdDate,
        Field_198_customer_created_by: customerDetails.createdBy && (customerDetails.createdBy.userFirstName + ' ' + customerDetails.createdBy.userLastName),
        Field_199_customer_last_updated_date: customerDetails.updatedDate,
        Field_200_customer_last_updated_by: customerDetails.updatedBy && (customerDetails.updatedBy.userFirstName + ' ' + customerDetails.updatedBy.userLastName),
      }
    });
  }
}

export const updateCustomerBasicDetails = (customerDetails, setStateFunc) => {
  if (customerDetails) {

    setStateFunc((prevState) => {
      return {
        ...prevState,
        Field_159_customer_id: customerDetails.customerId,
        Field_160_customer_title: customerDetails.userTitle && { key: customerDetails.userTitle.titleId, value: customerDetails.userTitle.titleName },
        Field_161_customer_first_name: customerDetails.firstName,
        Field_162_customer_last_name: customerDetails.lastName,
        Field_163_customer_display_name: customerDetails.displayName,
        Field_164_customer_nationality: customerDetails.nationality && { key: customerDetails.nationality.countryId, value: customerDetails.nationality.countryName },
        Field_165_customer_date_of_birth: customerDetails.dateOfBirth,
        Field_166_customer_marital_status: customerDetails.maritalStatus && { key: customerDetails.maritalStatus.maritalStatusId, value: customerDetails.maritalStatus.maritalStatusName },
        Field_167_customer_type: customerDetails.customerType && { key: customerDetails.customerType.customerTypeId, value: customerDetails.customerType.customerTypeName },
        Field_196_customer_email: customerDetails.email,
      }
    });
  }
}


export const updateCustomerAddressDetails = (customerDetails, setStateFunc) => {
  if (customerDetails && customerDetails.addressStoreModel) {
    const model = customerDetails.addressStoreModel
    setStateFunc((prevState) => {
      return {
        ...prevState,

        addressId: model.addressId,
        Field_168_reg_address_line1: model.registeredAddressLine1,
        Field_169_reg_address_line2: model.registeredAddressLine2,
        Field_170_reg_address_city: model.registeredAddressCity,
        Field_171_reg_address_state: model.registeredAddressState,
        Field_172_reg_address_country: model.registeredAddressCountry && { key: model.registeredAddressCountry.countryId, value: model.registeredAddressCountry.countryName },
        Field_173_reg_address_postal_code: model.registeredAddressPostalCode,
        Field_174_com_address_line1: model.communicationAddressLine1,
        Field_175_com_address_line2: model.communicationAddressLine2,
        Field_176_com_address_city: model.communicationAddressCity,
        Field_177_com_address_state: model.communicationAddressState,
        Field_178_com_address_country: model.communicationAddressCountry && { key: model.communicationAddressCountry.countryId, value: model.communicationAddressCountry.countryName },
        Field_179_com_address_postal_code: model.communicationAddressPostalCode,
      }
    });
  }
}


export const updateCustomerAdditionalDetails = (customerDetails, setStateFunc) => {
  if (customerDetails) {

    setStateFunc((prevState) => {
      return {
        ...prevState,

        Field_180_educational_qualification: customerDetails.customerEducationLevel && { key: customerDetails.customerEducationLevel.educationLevelId, value: customerDetails.customerEducationLevel.educationLevelName },
        Field_181_occupation_type: customerDetails.customerProfession && { key: customerDetails.customerProfession.professionId, value: customerDetails.customerProfession.professionName },
        Field_182_organisation_name: customerDetails.customerOrganisationName,
        Field_183_yearly_income: customerDetails.customerYearlyIncome && { key: customerDetails.customerYearlyIncome.yearlyIncomeId, value: customerDetails.customerYearlyIncome.yearlyIncomeName },
        Field_194_home_ownership_type: customerDetails.homeOwnershipType && { key: customerDetails.homeOwnershipType.homeOwnershipTypeId, value: customerDetails.homeOwnershipType.homeOwnershipTypeName },
        Field_184_nominee_relationship_type: customerDetails.nomineeRelationshipType && { key: customerDetails.nomineeRelationshipType.relationshipTypeId, value: customerDetails.nomineeRelationshipType.relationshipTypeName },
        Field_185_nominee_first_name: customerDetails.nomineeFirstName,
        Field_186_nominee_last_name: customerDetails.nomineeLastName,
        Field_195_nominee_date_of_birth: customerDetails.nomineeDateOfBirth
      }
    });
  }
}
export const updateCustomerProductDetails = (customerDetails, setStateFunc) => {
  if (customerDetails) {
    setStateFunc((prevState) => {
      return {
        productsList: customerDetails.productStoreModelList.map(item => {
          return {
            productId: item.productId,
            accountId: item.accountId,
            createdDate: item.createdDate,
            productType: {
              productTypeId: item.productType.productTypeId,
              productTypeName: item.productType.productTypeName,
            },
            productBranch: {
              branchTypeId: item.productBranch.branchTypeId,
              branchTypeName: item.productBranch.branchTypeName,
            }
          }
        })
      }
    });
  }
}
export const updateCustomerDocumentDetails = (customerDetails, setStateFunc) => {
  if (customerDetails) {
    setStateFunc((prevState) => {
      return {
        documentsList: customerDetails.documentStoreModelsList.map(item => {
          return {
            documentId: item.documentId,
            documentLinkPath: item.documentLinkPath,
            createdDate: item.createdDate,
            documentType: {
              documentTypeId: item.documentType.documentTypeId,
              documentTypeName: item.documentType.documentTypeName,
            }
          }
        })
      }
    });
  }
}