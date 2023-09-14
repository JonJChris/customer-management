package com.management.customer.model.transaction.request;

import com.management.customer.model.authorisation.UserModel;
import com.management.customer.model.master.BranchModel;
import com.management.customer.model.master.CountryModel;
import com.management.customer.model.master.ProductModel;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public record ProductRelationshipModel(
        Long id,
        Long productStoreId,
        String accountId,
        ProductModel productType,
        BranchModel productBranch,
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
        LocalDateTime createdDate,
        UserModel createdBy
) {
}
