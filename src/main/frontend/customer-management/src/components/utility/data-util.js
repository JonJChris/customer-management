
export const updateRequestHeadDetails = (requestDetails, setStateFunc) => {
  if (requestDetails) {
    setStateFunc((prevState) => {
      return {
        ...prevState,
        Field_100_request_id: requestDetails.requestId,
        Field_102_request_type: requestDetails.requestType && { key: requestDetails.requestType.requestTypeId, value: requestDetails.requestType.requestTypeName },
        Field_101_request_created: requestDetails.requestCreateDate,
        Field_103_request_status: requestDetails.requestStage && { key: requestDetails.requestStage.requestStageId, value: requestDetails.requestStage.requestStageName },
      }
    });
  }
}

export const updateBasicDetails = (requestDetails, setStateFunc) => {
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

export const updateAddressDetails = (requestDetails, setStateFunc) => {
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

export const updateAdditionalDetails = (requestDetails, setStateFunc) => {
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

export const buildRequestBody = (requestHeadDetails, basicDetails, addressDetails, additionalDetails, userDetail) => {
  const requestBody = { customerModel: {}, addressModel: {} }

  requestBody['requestId'] = requestHeadDetails.Field_100_request_id;
  requestBody['requestType'] = { requestTypeId: requestHeadDetails.Field_102_request_type.key, requestTypeName: requestHeadDetails.Field_102_request_type.value };
  requestBody['requestStage'] = { requestStageId: requestHeadDetails.Field_103_request_status.key, requestStageName: requestHeadDetails.Field_103_request_status.value };
  requestBody['requestCreateDate'] = requestHeadDetails.Field_101_request_created;

  requestBody.customerModel['customerId'] = basicDetails.Field_104_customer_id;
  requestBody.customerModel['userTitle'] = { titleId: basicDetails.Field_105_customer_title.key, titleName: basicDetails.Field_105_customer_title.value };
  requestBody.customerModel['firstName'] = basicDetails.Field_106_customer_first_name;
  requestBody.customerModel['lastName'] = basicDetails.Field_107_customer_last_name;
  requestBody.customerModel['displayName'] = basicDetails.Field_108_customer_display_name;
  requestBody.customerModel['nationality'] = { countryId: basicDetails.Field_109_customer_nationality.key, countryName: basicDetails.Field_109_customer_nationality.value };
  requestBody.customerModel['email'] = basicDetails.Field_144_customer_email;
  requestBody.customerModel['dateOfBirth'] = basicDetails.Field_110_customer_date_of_birth;
  requestBody.customerModel['maritalStatus'] = { maritalStatusId: basicDetails.Field_112_customer_marital_status.key, maritalStatusName: basicDetails.Field_112_customer_marital_status.value };
  requestBody.customerModel['customerType'] = { customerTypeId: basicDetails.Field_113_customer_type.key, customerTypeName: basicDetails.Field_113_customer_type.value };
  requestBody.customerModel['customerEducationLevel'] = { educationLevelId: additionalDetails.Field_126_educational_qualification.key, educationLevelName: additionalDetails.Field_126_educational_qualification.value };
  requestBody.customerModel['customerProfession'] = { professionId: additionalDetails.Field_127_occupation_type.key, professionName: additionalDetails.Field_127_occupation_type.value };
  requestBody.customerModel['customerOrganisationName'] = additionalDetails.Field_128_organisation_name;
  requestBody.customerModel['customerYearlyIncome'] = { yearlyIncomeId: additionalDetails.Field_130_yearly_income.key, yearlyIncomeName: additionalDetails.Field_130_yearly_income.value };
  requestBody.customerModel['nomineeRelationshipType'] = { relationshipTypeId: additionalDetails.Field_132_nominee_relationship_type.key, relationshipTypeName: additionalDetails.Field_132_nominee_relationship_type.value };
  requestBody.customerModel['nomineeFirstName'] = additionalDetails.Field_133_nominee_first_name;
  requestBody.customerModel['nomineeLastName'] = additionalDetails.Field_134_nominee_last_name;
  requestBody.customerModel['nomineeDateOfBirth'] = additionalDetails.Field_143_nominee_date_of_birth;

  requestBody.addressModel['addressId'] = addressDetails.addressId;
  requestBody.addressModel['registeredAddressLine1'] = addressDetails.Field_114_reg_address_line1;
  requestBody.addressModel['registeredAddressLine2'] = addressDetails.Field_115_reg_address_line2;
  requestBody.addressModel['registeredAddressCity'] = addressDetails.Field_116_reg_address_city;
  requestBody.addressModel['registeredAddressState'] = addressDetails.Field_117_reg_address_state;
  requestBody.addressModel['registeredAddressCountry'] = { countryId: addressDetails.Field_118_reg_address_country.key, countryName: addressDetails.Field_118_reg_address_country.value };
  requestBody.addressModel['registeredAddressPostalCode'] = addressDetails.Field_119_reg_address_postal_code;

  requestBody.addressModel['communicationAddressLine1'] = addressDetails.Field_120_com_address_line1;
  requestBody.addressModel['communicationAddressLine2'] = addressDetails.Field_121_com_address_line2;
  requestBody.addressModel['communicationAddressCity'] = addressDetails.Field_122_com_address_city;
  requestBody.addressModel['communicationAddressState'] = addressDetails.Field_123_com_address_state;
  requestBody.addressModel['communicationAddressCountry'] = { countryId: addressDetails.Field_124_com_address_country.key, countryName: addressDetails.Field_124_com_address_country.value };
  requestBody.addressModel['communicationAddressPostalCode'] = addressDetails.Field_125_com_address_postal_code;
  requestBody['requestSubmittedBy'] = {
    userId: userDetail.userId,
    username: userDetail.username,
    userFirstName: userDetail.userFirstName,
    userLastName: userDetail.userLastName
  }

  console.log(JSON.stringify(requestBody));

  return requestBody;

}