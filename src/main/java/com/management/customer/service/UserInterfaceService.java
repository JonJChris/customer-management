package com.management.customer.service;

import com.management.customer.entity.master.StageType;
import com.management.customer.entity.master.RequestType;
import com.management.customer.entity.ui.UiFieldRules;
import com.management.customer.enums.UIFieldArea;
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



    Optional<List<UIFieldModel>> getRequestDetailsUIInputFieldRules(RequestType requestTypeId, StageType stageTypeId){
        List<UiFieldRules> uiFieldRulesList = userInterfaceRulesRepository.findByRequestTypeIdAndStageTypeIdAndUserInterfaceField_FieldTypeAndUserInterfaceField_FieldArea(
                requestTypeId,
                stageTypeId,
                UIFieldTypeEnum.INPUT.name(),
                UIFieldArea.REQUEST_DETAILS.name()
        );
        if(uiFieldRulesList.isEmpty()){
            return Optional.empty();
        }else{
            return Optional.of(uiFieldRulesList.stream().map(UIFieldTransformer::entityToModel).toList());
        }

    }

    Optional<List<UIFieldModel>> getRequestDetailsUITabFieldRules(RequestType requestTypeId, StageType stageTypeId){
        List<UiFieldRules> uiFieldRulesList = userInterfaceRulesRepository.findByRequestTypeIdAndStageTypeIdAndUserInterfaceField_FieldTypeAndUserInterfaceField_FieldArea(
                requestTypeId,
                stageTypeId,
                UIFieldTypeEnum.TAB.name(),
                UIFieldArea.REQUEST_DETAILS.name()
        );
        if(uiFieldRulesList.isEmpty()){
            return Optional.empty();
        }else{
            return Optional.of(uiFieldRulesList.stream().map(UIFieldTransformer::entityToModel).toList());
        }

    }

    Optional<List<UIFieldModel>> getRequestDetailsUIButtonFieldRules(RequestType requestTypeId, StageType stageTypeId){
        List<UiFieldRules> uiFieldRulesList = userInterfaceRulesRepository.findByRequestTypeIdAndStageTypeIdAndUserInterfaceField_FieldTypeAndUserInterfaceField_FieldArea(
                requestTypeId,
                stageTypeId,
                UIFieldTypeEnum.BUTTON.name(),
                UIFieldArea.REQUEST_DETAILS.name());
        if(uiFieldRulesList.isEmpty()){
            return Optional.empty();
        }else{
            return Optional.of(uiFieldRulesList.stream().map(UIFieldTransformer::entityToModel).toList());
        }

    }
}
