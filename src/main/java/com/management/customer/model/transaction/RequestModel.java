package com.management.customer.model.transaction;

import com.management.customer.model.authorisation.UserModel;
import com.management.customer.model.master.RequestStageModel;
import com.management.customer.model.master.RequestTypeModel;
import com.management.customer.model.userInterface.UIFieldModel;

import java.time.LocalDateTime;
import java.util.List;

public record RequestModel(
        Long requestId,
        RequestTypeModel requestType,
        RequestStageModel requestStage,
        CustomerModel customerModel,
        AddressModel addressModel,
        LocalDateTime requestCreateDate,
        UserModel requestCreatedBy,
        LocalDateTime requestLastUpdatedDate,
        UserModel requestLastUpdatedBy,
        List<UIFieldModel> uiInputFieldModelsList,
        List<UIFieldModel> uiTabModelsList,
        List<UIFieldModel> uiButtonModelsList,
        UserModel requestSubmittedBy

) {
}
