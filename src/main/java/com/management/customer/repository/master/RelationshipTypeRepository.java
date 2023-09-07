package com.management.customer.repository.master;

import com.management.customer.entity.master.RelationshipType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RelationshipTypeRepository extends JpaRepository<RelationshipType, Integer> {
}
