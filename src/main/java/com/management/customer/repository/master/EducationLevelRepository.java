package com.management.customer.repository.master;

import com.management.customer.entity.master.EducationLevelType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EducationLevelRepository extends JpaRepository<EducationLevelType, Integer> {
}
