package com.management.customer.repository.master;

import com.management.customer.entity.master.RequestStage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestStageRepository extends JpaRepository<RequestStage, Integer> {
}