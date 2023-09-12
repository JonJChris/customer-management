package com.management.customer.tranformer.master;

import com.management.customer.model.master.ProductModel;
import com.management.customer.entity.master.ProductType;

public class ProductTypeTransformer {
    public static ProductModel entityToModel(ProductType productType){
            return new ProductModel(productType.getId(), productType.getProductCode(), productType.getProductName(), productType.getProductDescription());
        }

}
