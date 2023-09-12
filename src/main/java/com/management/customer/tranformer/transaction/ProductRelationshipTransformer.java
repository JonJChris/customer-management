package com.management.customer.tranformer.transaction;

import com.management.customer.entity.transaction.RequestProductRelationship;
import com.management.customer.model.transaction.request.ProductRelationshipModel;
import com.management.customer.tranformer.master.BranchTypeTransformer;
import com.management.customer.tranformer.master.ProductTypeTransformer;

public class ProductRelationshipTransformer {
    public static ProductRelationshipModel entityToModel(RequestProductRelationship requestProductRelationship){
        return new ProductRelationshipModel(requestProductRelationship.getId(), requestProductRelationship.getAccountId(),
                ProductTypeTransformer.entityToModel(requestProductRelationship.getProductType()),
                BranchTypeTransformer.entityToModel(requestProductRelationship.getBranchType()),
                requestProductRelationship.getCreatedDate(),
                UserTransformer.entityToModel(requestProductRelationship.getCreatedBy()));
    }
}
