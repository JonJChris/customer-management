package com.management.customer.model.store;

import com.management.customer.model.authorisation.UserModel;
import com.management.customer.model.master.StageTypeModel;
import com.management.customer.model.master.RequestTypeModel;

import java.time.LocalDateTime;

public record RequestStoreModel(
        Long requestId,
        RequestTypeModel requestType,
        StageTypeModel requestStage,
        LocalDateTime requestCreateDate,
        UserModel requestCreatedBy,
        LocalDateTime requestLastUpdatedDate,
        UserModel requestLastUpdatedBy
) {
}
