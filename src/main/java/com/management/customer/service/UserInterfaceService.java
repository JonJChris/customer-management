package com.management.customer.service;

import com.management.customer.entity.master.RequestStage;
import com.management.customer.entity.master.RequestType;
import com.management.customer.entity.master.UIFieldRules;
import com.management.customer.model.userInterface.UIFieldModel;
import com.management.customer.repository.master.UserInterfaceRulesRepository;
import com.management.customer.tranformer.UIFieldTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
@Service
public class UserInterfaceService {
    @Autowired
    UserInterfaceRulesRepository userInterfaceRulesRepository;

    Optional<List<UIFieldModel>> getUIFieldRules(RequestType requestTypeId, RequestStage requestStageId){
        List<UIFieldRules> uiFieldRulesList = userInterfaceRulesRepository.findByRequestTypeIdAndRequestStageId(requestTypeId, requestStageId);
        if(uiFieldRulesList.isEmpty()){
            return Optional.empty();
        }else{
            return Optional.of(uiFieldRulesList.stream().map(UIFieldTransformer::entityToModel).toList());
        }

    }
}
