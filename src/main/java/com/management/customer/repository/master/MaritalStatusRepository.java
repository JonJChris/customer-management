package com.management.customer.repository.master;

import com.management.customer.entity.lookup.MaritalStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaritalStatusRepository extends JpaRepository<MaritalStatus, Integer> {
}
