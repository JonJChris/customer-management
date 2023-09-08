package com.management.customer.tranformer;

import com.management.customer.model.master.ProductModel;
import com.management.customer.entity.master.ProductType;

public class ProductTransformer {
    public static ProductModel entityToModel(ProductType productType){
            return new ProductModel(productType.getId(), productType.getProductCode(), productType.getProductName(), productType.getProductDescription());
        }

}
