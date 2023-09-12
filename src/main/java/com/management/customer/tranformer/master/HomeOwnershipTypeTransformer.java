package com.management.customer.tranformer.master;

import com.management.customer.model.master.HomeOwnershipTypeModel;
import com.management.customer.entity.master.HomeOwnershipType;

public class HomeOwnershipTypeTransformer {
    public static HomeOwnershipTypeModel entityToModel(HomeOwnershipType homeOwnershipType){
        return new HomeOwnershipTypeModel(homeOwnershipType.getId(), homeOwnershipType.getHomeOwnershipType());
        }

}
