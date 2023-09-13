package com.management.customer.tranformer.master;

import com.management.customer.model.master.StageTypeModel;
import com.management.customer.entity.master.StageType;

public class StageTypeTransformer {
    public static StageTypeModel entityToModel(StageType stageType){
            return new StageTypeModel(stageType.getId(), stageType.getStageName());
        }

}
