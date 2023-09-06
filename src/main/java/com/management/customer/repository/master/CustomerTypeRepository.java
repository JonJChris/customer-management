package com.management.customer.repository.master;

import com.management.customer.entity.lookup.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerTypeRepository extends JpaRepository<CustomerType, Integer> {
}
