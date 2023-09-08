package com.management.customer.tranformer;

import com.management.customer.model.master.BranchModel;
import com.management.customer.entity.master.BranchType;

public class BranchTransformer {
    public static BranchModel entityToModel(BranchType branch){
            return new BranchModel(branch.getId(), branch.getBranchCode(), branch.getBranchName(), branch.getBranchDescription(),
                    branch.getProductsList().stream().map(ProductTransformer::entityToModel).toList());
        }

}
