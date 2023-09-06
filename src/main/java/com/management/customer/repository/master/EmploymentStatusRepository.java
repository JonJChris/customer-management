package com.management.customer.repository.master;

import com.management.customer.entity.lookup.EmploymentStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmploymentStatusRepository extends JpaRepository<EmploymentStatus, Integer> {
}
