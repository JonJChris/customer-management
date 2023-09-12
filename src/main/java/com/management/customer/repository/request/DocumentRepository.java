package com.management.customer.repository.request;

import com.management.customer.entity.transaction.RequestDocument;
import com.management.customer.entity.transaction.RequestProductRelationship;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<RequestDocument, Long> {
}
