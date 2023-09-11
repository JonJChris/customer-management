package com.management.customer.model.transaction.store;

import com.management.customer.model.authorisation.UserModel;
import com.management.customer.model.master.RequestStageModel;
import com.management.customer.model.master.RequestTypeModel;

import java.time.LocalDateTime;

public record RequestStoreModel(
        Long requestId,
        RequestTypeModel requestType,
        RequestStageModel requestStage,
        LocalDateTime requestCreateDate,
        UserModel requestCreatedBy,
        LocalDateTime requestLastUpdatedDate,
        UserModel requestLastUpdatedBy
) {
}
