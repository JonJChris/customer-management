package com.management.customer.tranformer.store;

import com.management.customer.entity.transaction.Request;
import com.management.customer.model.store.RequestStoreModel;
import com.management.customer.tranformer.master.StageTypeTransformer;
import com.management.customer.tranformer.master.RequestTypeTransformer;
import com.management.customer.tranformer.transaction.UserTransformer;

public class RequestStoreTransformer {

    public static RequestStoreModel entityToModel(Request request){
        return new RequestStoreModel(
                request.getRequestId(),
                RequestTypeTransformer.entityToModel(request.getRequestType()),
                StageTypeTransformer.entityToModel(request.getStageType()),
                request.getCreatedDate(),
                UserTransformer.entityToModel(request.getCreatedBy()),
                request.getUpdatedDate(),
                UserTransformer.entityToModel(request.getUpdatedBy())
        );
    }


}
