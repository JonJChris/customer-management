package com.management.customer.model.store;

import com.management.customer.model.authorisation.UserModel;
import com.management.customer.model.master.DocumentTypeModel;

import java.time.LocalDateTime;

public record DocumentStoreModel(
        Long documentId,
        DocumentTypeModel documentType,
        String documentLinkPath,
        LocalDateTime createdDate,
        UserModel createdBy
) {
}
