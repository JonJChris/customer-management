package com.management.customer.tranformer;

import com.management.customer.model.master.RequestStageModel;
import com.management.customer.entity.master.RequestStage;

public class RequestStageTransformer {
    public static RequestStageModel entityToModel(RequestStage requestStage){
            return new RequestStageModel(requestStage.getId(), requestStage.getRequestStage());
        }

}
