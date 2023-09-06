package com.management.customer.repository.master;

import com.management.customer.entity.lookup.RelationshipType;
import com.management.customer.entity.lookup.RequestType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RelationshipTypeRepository extends JpaRepository<RelationshipType, Integer> {
}
