package com.management.customer.repository.master;

import com.management.customer.entity.master.EmploymentStatusType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmploymentStatusRepository extends JpaRepository<EmploymentStatusType, Integer> {
}
