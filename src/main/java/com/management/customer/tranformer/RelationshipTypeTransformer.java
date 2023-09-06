package com.management.customer.tranformer;

import com.management.customer.dto.RelationshipTypeDTO;
import com.management.customer.dto.RequestTypeDTO;
import com.management.customer.entity.lookup.RelationshipType;
import com.management.customer.entity.lookup.RequestType;

public class RelationshipTypeTransformer {
        public static RelationshipTypeDTO entityToModel(RelationshipType relationshipType){
            return new RelationshipTypeDTO(relationshipType.getId(), relationshipType.getRelationshipType());
        }

}
