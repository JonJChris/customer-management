package com.management.customer.tranformer;

import com.management.customer.model.master.ProductModel;
import com.management.customer.entity.master.Product;

public class ProductTransformer {
    public static ProductModel entityToModel(Product product){
            return new ProductModel(product.getId(), product.getProductCode(), product.getProductName(), product.getProductDescription());
        }

}
