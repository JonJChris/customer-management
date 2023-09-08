package com.management.customer.repository.master;

import com.management.customer.entity.master.MaritalStatusType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaritalStatusRepository extends JpaRepository<MaritalStatusType, Integer> {
}
