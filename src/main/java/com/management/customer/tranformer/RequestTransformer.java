package com.management.customer.tranformer;

import com.management.customer.model.transaction.RequestModel;
import com.management.customer.entity.transaction.Request;
import com.management.customer.model.userInterface.UIFieldModel;

import java.util.List;

public class RequestTransformer {
    public static RequestModel entityToModel(Request request) {
     return entityToModel(request, null);
    }
    public static RequestModel entityToModel(Request request, List<UIFieldModel> uiFieldModelList) {
        return new RequestModel(
                request.getRequestId(),
                RequestTypeTransformer.entityToModel(request.getRequestType()),
                RequestStageTransformer.entityToModel(request.getRequestStage()),
                CustomerTransformer.entityToModel(request.getCustomer()),
                AddressTransformer.entityToModel(request.getAddress()),
                request.getCreatedOn(),
                UserTransformer.entityToModel(request.getCreatedBy()),
                request.getUpdatedOn(),
                UserTransformer.entityToModel(request.getUpdatedBy()),
                uiFieldModelList
                );
    }
}
