package com.management.customer.repository.request;

import com.management.customer.entity.transaction.RequestProductRelationship;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRelationshipRepository extends JpaRepository<RequestProductRelationship, Long> {
}
