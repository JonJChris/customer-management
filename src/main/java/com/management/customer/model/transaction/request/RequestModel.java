package com.management.customer.model.transaction.request;

import com.management.customer.model.authorisation.UserModel;
import com.management.customer.model.master.StageTypeModel;
import com.management.customer.model.master.RequestTypeModel;
import com.management.customer.model.userInterface.UIFieldModel;

import java.time.LocalDateTime;
import java.util.List;

public record RequestModel(
        Long requestId,
        RequestTypeModel requestType,
        StageTypeModel currentRequestStage,
        CustomerModel customerModel,
        AddressModel addressModel,
        List<ProductRelationshipModel> productRelationshipModelList,
        List<DocumentModel> documentModelList,
        List<RequestStageModel> allRequestStagesList,
        List<UIFieldModel> uiInputFieldModelsList,
        List<UIFieldModel> uiTabModelsList,
        List<UIFieldModel> uiButtonModelsList,
        LocalDateTime createdDate,
        UserModel createdBy,
        LocalDateTime updatedDate,
        UserModel updatedBy,
        UserModel requestSubmittedBy

) {
}
