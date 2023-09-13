package com.management.customer.tranformer.master;

import com.management.customer.entity.master.StageType;
import com.management.customer.entity.master.StatusType;
import com.management.customer.model.master.StageTypeModel;
import com.management.customer.model.master.StatusTypeModel;

public class StatusTypeTransformer {
    public static StatusTypeModel entityToModel(StatusType statusType){
            return new StatusTypeModel(statusType.getId(), statusType.getStatusTypeName());
        }

}
