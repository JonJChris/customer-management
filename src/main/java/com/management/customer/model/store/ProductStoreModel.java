package com.management.customer.model.store;

import com.management.customer.model.authorisation.UserModel;
import com.management.customer.model.master.BranchModel;
import com.management.customer.model.master.ProductModel;

import java.time.LocalDateTime;

public record ProductStoreModel(
        Long productId,
        String accountId,
        ProductModel productType,
        BranchModel productBranch,
        LocalDateTime createdDate,
        UserModel createdBy
) {
}
