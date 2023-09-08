package com.management.customer.tranformer;

import com.management.customer.model.transaction.RequestModel;
import com.management.customer.entity.transaction.Request;
import com.management.customer.model.userInterface.UIFieldModel;

import java.util.List;

public class RequestTransformer {
    public static RequestModel entityToModel(Request request) {
     return entityToModel(request, null, null);
    }
    public static RequestModel entityToModel(Request request, List<UIFieldModel> uiInputFieldModelList, List<UIFieldModel> uiTabModelList) {
        return new RequestModel(
                request.getRequestId(),
                RequestTypeTransformer.entityToModel(request.getRequestType()),
                RequestStageTransformer.entityToModel(request.getStageType()),
                CustomerTransformer.entityToModel(request.getRequestCustomer()),
                AddressTransformer.entityToModel(request.getRequestAddress()),
                request.getCreatedOn(),
                UserTransformer.entityToModel(request.getCreatedBy()),
                request.getUpdatedOn(),
                UserTransformer.entityToModel(request.getUpdatedBy()),
                uiInputFieldModelList,
                uiTabModelList,
                null
                );
    }
}
