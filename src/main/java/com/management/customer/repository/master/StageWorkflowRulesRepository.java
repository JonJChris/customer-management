package com.management.customer.repository.master;

import com.management.customer.entity.master.StageType;
import com.management.customer.entity.master.RequestType;
import com.management.customer.entity.workflow.StageWorkflowRules;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface StageWorkflowRulesRepository extends JpaRepository<StageWorkflowRules, Integer> {
    public Optional<StageWorkflowRules> findByRequestTypeAndCurrentStageTypeAndStageAction(
                                                                                        @Param("requestType") RequestType requestType,
                                                                                        @Param("currentStageType") StageType currentStageType,
                                                                                        @Param("stageAction") String stageAction);
}
