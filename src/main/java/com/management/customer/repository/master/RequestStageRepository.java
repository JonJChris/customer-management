package com.management.customer.repository.master;

import com.management.customer.entity.master.StageType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestStageRepository extends JpaRepository<StageType, Integer> {
}
