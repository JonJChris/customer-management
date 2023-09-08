package com.management.customer.service;

import com.management.customer.entity.master.StageType;
import com.management.customer.entity.master.RequestType;
import com.management.customer.entity.master.UiFieldRules;
import com.management.customer.model.userInterface.UIFieldModel;
import com.management.customer.enums.UIFieldTypeEnum;
import com.management.customer.repository.master.UserInterfaceRulesRepository;
import com.management.customer.tranformer.UIFieldTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserInterfaceService {
    @Autowired
    UserInterfaceRulesRepository userInterfaceRulesRepository;



    Optional<List<UIFieldModel>> getUIInputFieldRules(RequestType requestTypeId, StageType stageTypeId){
        List<UiFieldRules> uiFieldRulesList = userInterfaceRulesRepository.findByRequestTypeIdAndStageTypeIdAndUserInterfaceField_FieldType(requestTypeId, stageTypeId, UIFieldTypeEnum.INPUT.name());
        if(uiFieldRulesList.isEmpty()){
            return Optional.empty();
        }else{
            return Optional.of(uiFieldRulesList.stream().map(UIFieldTransformer::entityToModel).toList());
        }

    }    Optional<List<UIFieldModel>> getUITabFieldRules(RequestType requestTypeId, StageType stageTypeId){
        List<UiFieldRules> uiFieldRulesList = userInterfaceRulesRepository.findByRequestTypeIdAndStageTypeIdAndUserInterfaceField_FieldType(requestTypeId, stageTypeId, UIFieldTypeEnum.TAB.name());
        if(uiFieldRulesList.isEmpty()){
            return Optional.empty();
        }else{
            return Optional.of(uiFieldRulesList.stream().map(UIFieldTransformer::entityToModel).toList());
        }

    }
}
