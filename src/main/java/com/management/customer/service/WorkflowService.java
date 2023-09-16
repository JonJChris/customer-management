package com.management.customer.service;

import com.management.customer.entity.authrisation.User;
import com.management.customer.entity.master.StageType;
import com.management.customer.entity.master.RequestType;
import com.management.customer.entity.master.StatusType;
import com.management.customer.entity.workflow.StageWorkflowRules;
import com.management.customer.entity.transaction.Request;
import com.management.customer.entity.transaction.RequestStage;
import com.management.customer.enums.StatusTypeEnum;
import com.management.customer.exceptions.NoDataFoundException;
import com.management.customer.model.master.StageTypeModel;
import com.management.customer.repository.workflow.StageWorkflowRulesRepository;
import com.management.customer.repository.request.StageRepository;
import com.management.customer.tranformer.master.StageTypeTransformer;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class WorkflowService {
    @Autowired
    StageWorkflowRulesRepository stageWorkflowRulesRepository;
    @Autowired
    StageRepository stageRepository;



    public StageTypeModel getNextStageModel(RequestType requestType, StageType currentStageType, String stageAction){
        Optional<StageWorkflowRules> stageWorkflowRulesEntity = getNextStageEntity(requestType, currentStageType, stageAction);

        if(stageWorkflowRulesEntity.isEmpty()){
            throw new NoDataFoundException("Next Request Stage not found");
        }
        return StageTypeTransformer.entityToModel(stageWorkflowRulesEntity.get().getNextStageType());
    }
    public Optional<StageWorkflowRules> getNextStageEntity(RequestType requestType, StageType currentStageType, String stageAction){
        return stageWorkflowRulesRepository.findByRequestTypeAndCurrentStageTypeAndStageAction(requestType, currentStageType, stageAction);
    }

    @Transactional
    public void updateRequestStages(boolean updateCurrentStage, boolean updateNextStage, Request request, StageType currentStageType, StageType nextStageType, User user, boolean isRework){
        if(updateCurrentStage) {
            // update current stage to complete
            Optional<RequestStage> currentRequestStage = stageRepository.findByRequestAndStageType(request, currentStageType);
            if (currentRequestStage.isPresent()) {
                if(isRework){
                    currentRequestStage.get().setStatusType(new StatusType(StatusTypeEnum.PENDING.getStageId(), StatusTypeEnum.PENDING.getStageTypeName()));
                    currentRequestStage.get().setUpdatedDate(null);
                    currentRequestStage.get().setUpdatedBy(null);
                }else {
                    currentRequestStage.get().setStatusType(new StatusType(StatusTypeEnum.COMPLETE.getStageId(), StatusTypeEnum.COMPLETE.getStageTypeName()));
                    currentRequestStage.get().setUpdatedDate(LocalDateTime.now());
                    currentRequestStage.get().setUpdatedBy(user);
                }
                stageRepository.save(currentRequestStage.get());
            }
        }
        if(updateNextStage) {
            Optional<RequestStage> nextRequestStage = stageRepository.findByRequestAndStageType(request, nextStageType);
            if (nextRequestStage.isPresent()) {
                nextRequestStage.get().setStatusType(new StatusType(StatusTypeEnum.IN_PROGRESS.getStageId(), StatusTypeEnum.IN_PROGRESS.getStageTypeName()));
                nextRequestStage.get().setUpdatedDate(LocalDateTime.now());
                nextRequestStage.get().setUpdatedBy(user);
                stageRepository.save(nextRequestStage.get());
            }
        }





//        if(nextRequestStage.isEmpty()){
//            System.out.println("*****************NEXT Request ID: "+request.getRequestId() +
//                    "Current Stage : "+currentStageType.getId()+", "+currentStageType.getStageName()+
//                    "Next Stage : "+nextStageType.getId()+", "+nextStageType.getStageName());
//            throw new NoDataFoundException("Next Stage not found : "+ nextStageType.getStageName());
//        }

//        if(currentRequestStage.isEmpty()){
//            System.out.println("*****************CURRENT Request ID: "+request.getRequestId() +
//                    "Current Stage : "+currentStageType.getId()+", "+currentStageType.getStageName()+
//                    "Next Stage : "+nextStageType.getId()+", "+nextStageType.getStageName());
//            throw new NoDataFoundException("Current Stage not found : "+ currentStageType.getStageName());
//
//        }


        // update next stage to pending


    }
}
