package com.management.customer.tranformer.transaction;

import com.management.customer.model.master.StageTypeModel;
import com.management.customer.model.transaction.request.RequestModel;
import com.management.customer.entity.transaction.Request;
import com.management.customer.model.userInterface.UIFieldModel;
import com.management.customer.tranformer.master.CountryTypeTransformer;
import com.management.customer.tranformer.master.StageTypeTransformer;
import com.management.customer.tranformer.master.RequestTypeTransformer;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class RequestTransformer {
    public static RequestModel entityToModel(Request request) {
     return entityToModel(request, null, null, null);
    }
    public static RequestModel entityToModel(Request request, List<UIFieldModel> uiInputFieldModelList, List<UIFieldModel> uiTabModelList, List<UIFieldModel> uiButtonModelList) {
        return new RequestModel(
                request.getRequestId(),
                RequestTypeTransformer.entityToModel(request.getRequestType()),
                StageTypeTransformer.entityToModel(request.getStageType()),
                CustomerTransformer.entityToModel(request.getRequestCustomer()),
                AddressTransformer.entityToModel(request.getRequestAddress()),
                Objects.isNull(request.getProductRelationshipList()) ? null: request.getProductRelationshipList().stream().map(ProductRelationshipTransformer::entityToModel).toList(),
                Objects.isNull(request.getDocumentListList()) ? null : request.getDocumentListList().stream().map(DocumentTransformer::entityToModel).toList(),
                Objects.isNull(request.getRequestRequestStages()) ? null :request.getRequestRequestStages().stream().map(RequestStageTransformer::entityToModel).toList() ,
                uiInputFieldModelList,
                uiTabModelList,
                uiButtonModelList,
                request.getCreatedDate(),
                UserTransformer.entityToModel(request.getCreatedBy()),
                request.getUpdatedDate(),
                UserTransformer.entityToModel(request.getUpdatedBy()),
                null
                );
    }
}
