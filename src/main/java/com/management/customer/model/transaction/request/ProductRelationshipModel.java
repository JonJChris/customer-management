package com.management.customer.model.transaction.request;

import com.management.customer.model.authorisation.UserModel;
import com.management.customer.model.master.BranchModel;
import com.management.customer.model.master.CountryModel;
import com.management.customer.model.master.ProductModel;

import java.time.LocalDateTime;

public record ProductRelationshipModel(
        Long productId,
        String accountId,
        ProductModel productType,
        BranchModel productBranch,
        LocalDateTime createdDate,
        UserModel createdBy
) {
}
