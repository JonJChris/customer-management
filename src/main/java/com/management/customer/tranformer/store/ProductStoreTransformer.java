package com.management.customer.tranformer.store;

import com.management.customer.entity.store.ProductStore;
import com.management.customer.entity.transaction.RequestProductRelationship;
import com.management.customer.model.store.ProductStoreModel;
import com.management.customer.model.transaction.request.ProductRelationshipModel;
import com.management.customer.tranformer.master.BranchTypeTransformer;
import com.management.customer.tranformer.master.ProductTypeTransformer;
import com.management.customer.tranformer.transaction.UserTransformer;

public class ProductStoreTransformer {
    public static ProductStoreModel entityToModel(ProductStore productStore){
        return new ProductStoreModel(productStore.getProductId(), productStore.getAccountId(),
                ProductTypeTransformer.entityToModel(productStore.getProductType()),
                BranchTypeTransformer.entityToModel(productStore.getBranchType()),
                productStore.getCreatedDate(),
                UserTransformer.entityToModel(productStore.getCreatedBy()));
    }
}
