package com.management.customer.tranformer.master;

import com.management.customer.model.master.BranchModel;
import com.management.customer.entity.master.BranchType;

public class BranchTypeTransformer {
    public static BranchModel entityToModel(BranchType branch){
            return new BranchModel(branch.getId(), branch.getBranchCode(), branch.getBranchName(), branch.getBranchDescription());
        }

}
