package com.management.customer.repository.master;

import com.management.customer.entity.master.CustomerStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerStatusRepository extends JpaRepository<CustomerStatus, Integer> {
}
