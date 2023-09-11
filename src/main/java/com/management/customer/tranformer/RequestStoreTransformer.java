package com.management.customer.tranformer;

import com.management.customer.entity.transaction.Request;
import com.management.customer.model.authorisation.UserModel;
import com.management.customer.model.master.RequestStageModel;
import com.management.customer.model.master.RequestTypeModel;
import com.management.customer.model.transaction.request.RequestModel;
import com.management.customer.model.transaction.store.RequestStoreModel;
import com.management.customer.model.userInterface.UIFieldModel;

import java.time.LocalDateTime;
import java.util.List;

public class RequestStoreTransformer {

    public static RequestStoreModel entityToModel(Request request){
        return new RequestStoreModel(
                request.getRequestId(),
                RequestTypeTransformer.entityToModel(request.getRequestType()),
                RequestStageTransformer.entityToModel(request.getStageType()),
                request.getCreatedOn(),
                UserTransformer.entityToModel(request.getCreatedBy()),
                request.getUpdatedOn(),
                UserTransformer.entityToModel(request.getUpdatedBy())
        );
    }


}
