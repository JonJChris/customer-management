package com.management.customer.tranformer.transaction;

import com.management.customer.entity.transaction.RequestStage;
import com.management.customer.model.transaction.request.RequestStageModel;
import com.management.customer.tranformer.master.StageTypeTransformer;
import com.management.customer.tranformer.master.StatusTypeTransformer;

public class RequestStageTransformer {
    public static RequestStageModel entityToModel(RequestStage requestStage){
        return new RequestStageModel(
                requestStage.getId(),
                StageTypeTransformer.entityToModel(requestStage.getStageType()),
                StatusTypeTransformer.entityToModel(requestStage.getStatusType())
        );

    }
}
