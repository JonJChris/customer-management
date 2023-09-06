package com.management.customer.tranformer;

import com.management.customer.dto.HomeOwnershipTypeDTO;
import com.management.customer.dto.ProfessionDTO;
import com.management.customer.entity.lookup.HomeOwnershipType;
import com.management.customer.entity.lookup.Profession;

public class HomeOwnershipTypeTransformer {
    public static HomeOwnershipTypeDTO entityToModel(HomeOwnershipType homeOwnershipType){
        return new HomeOwnershipTypeDTO(homeOwnershipType.getId(), homeOwnershipType.getHomeOwnershipType());
        }

}
