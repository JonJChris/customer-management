
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
        email: model.email,
        Field_110_customer_date_of_birth: model.dateOfBirth,
        Field_112_customer_marital_status: model.maritalStatus && { key: model.maritalStatus.maritalStatusId, value: model.maritalStatus.maritalStatusName },
        Field_113_customer_type: model.customerType && { key: model.customerType.customerTypeId, value: model.customerType.customerTypeName },
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