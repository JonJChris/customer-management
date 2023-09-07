package com.management.customer.repository.request;

import com.management.customer.entity.transaction.Request;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepository extends JpaRepository<Request, Long> {
}
