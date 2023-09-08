package com.management.customer.repository.request;

import com.management.customer.entity.transaction.RequestCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<RequestCustomer, Long> {
}
