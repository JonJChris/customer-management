package com.management.customer.tranformer.master;

import com.management.customer.model.master.RequestStageModel;
import com.management.customer.entity.master.StageType;

public class RequestStageTypeTransformer {
    public static RequestStageModel entityToModel(StageType stageType){
            return new RequestStageModel(stageType.getId(), stageType.getStageName());
        }

}
