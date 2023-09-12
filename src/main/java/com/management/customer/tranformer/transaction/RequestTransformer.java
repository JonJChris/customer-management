package com.management.customer.tranformer.transaction;

import com.management.customer.model.transaction.request.RequestModel;
import com.management.customer.entity.transaction.Request;
import com.management.customer.model.userInterface.UIFieldModel;
import com.management.customer.tranformer.master.RequestStageTypeTransformer;
import com.management.customer.tranformer.master.RequestTypeTransformer;

import java.util.List;

public class RequestTransformer {
    public static RequestModel entityToModel(Request request) {
     return entityToModel(request, null, null, null);
    }
    public static RequestModel entityToModel(Request request, List<UIFieldModel> uiInputFieldModelList, List<UIFieldModel> uiTabModelList, List<UIFieldModel> uiButtonModelList) {
        return new RequestModel(
                request.getRequestId(),
                RequestTypeTransformer.entityToModel(request.getRequestType()),
                RequestStageTypeTransformer.entityToModel(request.getStageType()),
                CustomerTransformer.entityToModel(request.getRequestCustomer()),
                AddressTransformer.entityToModel(request.getRequestAddress()),
                request.getProductRelationshipList().stream().map(ProductRelationshipTransformer::entityToModel).toList(),
                request.getDocumentListList().stream().map(DocumentTransformer::entityToModel).toList(),
                request.getCreatedDate(),
                UserTransformer.entityToModel(request.getCreatedBy()),
                request.getUpdatedDate(),
                UserTransformer.entityToModel(request.getUpdatedBy()),
                uiInputFieldModelList,
                uiTabModelList,
                uiButtonModelList,
                null
                );
    }
}
