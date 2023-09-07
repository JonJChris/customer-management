package com.management.customer.tranformer;

import com.management.customer.model.master.RelationshipTypeModel;
import com.management.customer.entity.master.RelationshipType;

public class RelationshipTypeTransformer {
        public static RelationshipTypeModel entityToModel(RelationshipType relationshipType){
            return new RelationshipTypeModel(relationshipType.getId(), relationshipType.getRelationshipType());
        }

}
