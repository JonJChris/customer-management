package com.management.customer.repository.request;

import com.management.customer.entity.transaction.Address;
import com.management.customer.entity.transaction.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
