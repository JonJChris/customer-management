package com.management.customer.model.transaction.request;

import com.management.customer.model.master.StageTypeModel;
import com.management.customer.model.master.StatusTypeModel;

public record RequestStageModel(
        Long id,
        StageTypeModel stageTypeModel,
        StatusTypeModel statusTypeModel) {
}
