package com.management.customer.repository.master;

import com.management.customer.entity.master.CustomerStatusType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerStatusRepository extends JpaRepository<CustomerStatusType, Integer> {
}
