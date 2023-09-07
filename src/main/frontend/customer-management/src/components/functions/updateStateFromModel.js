
export const updateRequestHeadDetails = (requestDetails, setStateFunc) => {
    if (requestDetails) {
        setStateFunc((prevState) => {
        return {
          ...prevState,
          requestId: requestDetails.requestId,
          requestType: requestDetails.requestType.requestTypeId,
          requestCreated: requestDetails.requestCreateDate,
          requestStage: requestDetails.requestStage.requestStageId
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
          customerId: model.customerId,
          userTitle: model.userTitle && model.userTitle.titleId,
          firstName: model.firstName,
          lastName: model.lastName,
          displayName: model.displayName,
          nationality: model.nationality && model.nationality.countryId,
          email: model.email,
          dateOfBirth: model.dateOfBirth,
          maritalStatus: model.maritalStatus && model.maritalStatus.maritalStatusId,
          customerType: model.customerType && model.customerType.customerTypeId,
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
          registeredAddressLine1: model.registeredAddressLine1, 
          registeredAddressLine2: model.registeredAddressLine2, 
          registeredAddressCity: model.registeredAddressCity, 
          registeredAddressState: model.registeredAddressState, 
          registeredAddressCountry:model.registeredAddressCountry && model.registeredAddressCountry.countryId,
          registeredAddressPostalCode: model.registeredAddressPostalCode, 
          communicationAddressLine1: model.communicationAddressLine1, 
          communicationAddressLine2: model.communicationAddressLine2, 
          communicationAddressCity: model.communicationAddressCity, 
          communicationAddressState: model.communicationAddressState,  
          communicationAddressCountry: model.communicationAddressCountry && model.communicationAddressCountry.countryId, 
          communicationAddressPostalCode: model.communicationAddressPostalCode,        }
      });
    }
  }

  export const updateAdditionalDetails = (requestDetails, setStateFunc) => {
    if (requestDetails && requestDetails.customerModel) {
      const model = requestDetails.customerModel
      setStateFunc((prevState) => {
        return {
          ...prevState,

          customerEducationLevel:model.customerEducationLevel && model.customerEducationLevel.educationLevelId, 
          customerProfession:model.customerProfession && model.customerProfession.professionId, 
          customerOrganisationName:model.customerOrganisationName, 
          customerYearlyIncome:model.customerYearlyIncome && model.customerYearlyIncome.yearlyIncomeId,
          homeOwnershipType:model.homeOwnershipType && model.homeOwnershipType.homeOwnershipTypeId, 
          nomineeRelationshipType:model.nomineeRelationshipType && model.nomineeRelationshipType.relationshipTypeId, 
          nomineeFirstName:model.nomineeFirstName, 
          nomineeLastName: model.nomineeLastName, 
          nomineeDateOfBirth: model.nomineeDateOfBirth
        }
      });
    }
  }