package com.management.customer.repository.master;

import com.management.customer.entity.master.RequestStage;
import com.management.customer.entity.master.RequestType;
import com.management.customer.entity.master.UIFieldRules;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface UserInterfaceRulesRepository extends JpaRepository<UIFieldRules, Integer> {
//    @Query("select u from UIFieldRules u where u.requestTypeId = :requestTypeId and u.requestStageId = :requestStageId")
    List<UIFieldRules> findByRequestTypeIdAndRequestStageId(@Param("requestTypeId") RequestType requestTypeId, @Param("requestStageId")  RequestStage requestStageId);

}
