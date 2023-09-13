package com.management.customer.model.transaction.request;

import com.management.customer.entity.master.DocumentType;
import com.management.customer.model.authorisation.UserModel;
import com.management.customer.model.master.BranchModel;
import com.management.customer.model.master.DocumentTypeModel;
import com.management.customer.model.master.ProductModel;

import java.time.LocalDateTime;

public record DocumentModel(
        Long id,
        Long documentStoreId,
        DocumentTypeModel documentType,
        String documentLinkPath,
        LocalDateTime createdDate,
        UserModel createdBy
) {
}
