package com.management.customer.model.transaction.request;

import com.management.customer.model.authorisation.UserModel;
import com.management.customer.model.master.StageTypeModel;
import com.management.customer.model.master.RequestTypeModel;
import com.management.customer.model.userInterface.UIFieldModel;
import org.springframework.format.annotation.DateTimeFormat;

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
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
        LocalDateTime createdDate,
        UserModel createdBy,
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
        LocalDateTime updatedDate,
        UserModel updatedBy,
        Integer requestSubmittedBy,
        UserPermissionModel userPermissionModel
) {
}
