package com.management.customer.repository.request;

import com.management.customer.entity.master.StageType;
import com.management.customer.entity.transaction.Request;
import com.management.customer.entity.transaction.RequestStage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface StageRepository extends JpaRepository<RequestStage, Long> {

    public Optional<RequestStage> findByRequestAndStageType(@Param("request") Request request, @Param("stageType") StageType stageType);
}
