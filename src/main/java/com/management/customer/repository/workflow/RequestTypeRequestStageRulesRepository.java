package com.management.customer.repository.workflow;

import com.management.customer.entity.master.RequestType;
import com.management.customer.entity.workflow.RequestTypeRequestStageRules;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RequestTypeRequestStageRulesRepository extends JpaRepository<RequestTypeRequestStageRules, Integer> {
    List<RequestTypeRequestStageRules> findByRequestType(@Param("requestType")RequestType requestType);
}
