package com.management.customer.tranformer;

import com.management.customer.model.master.RequestStageModel;
import com.management.customer.entity.master.StageType;

public class RequestStageTransformer {
    public static RequestStageModel entityToModel(StageType stageType){
            return new RequestStageModel(stageType.getId(), stageType.getStageName());
        }

}
