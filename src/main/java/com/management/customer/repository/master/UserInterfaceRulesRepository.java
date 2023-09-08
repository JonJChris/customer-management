package com.management.customer.repository.master;

import com.management.customer.entity.master.StageType;
import com.management.customer.entity.master.RequestType;
import com.management.customer.entity.master.UiFieldRules;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserInterfaceRulesRepository extends JpaRepository<UiFieldRules, Integer> {
//    @Query("select u from UIFieldRules u where u.requestTypeId = :requestTypeId and u.requestStageId = :requestStageId")
    List<UiFieldRules> findByRequestTypeIdAndStageTypeIdAndUserInterfaceField_FieldType(@Param("requestTypeId") RequestType requestTypeId,
                                                                                @Param("stageTypeId") StageType stageTypeId,
                                                                                @Param("fieldType") String fieldType);

}

