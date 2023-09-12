package com.management.customer.service;

import com.management.customer.entity.authrisation.User;
import com.management.customer.entity.workflow.StageWorkflowRules;
import com.management.customer.model.master.RequestStageModel;
import com.management.customer.enums.StageActionEnum;
import com.management.customer.model.transaction.request.RequestModel;
import com.management.customer.entity.transaction.Request;
import com.management.customer.exceptions.NoDataFoundException;
import com.management.customer.model.userInterface.UIFieldModel;
import com.management.customer.repository.request.RequestRepository;
import com.management.customer.tranformer.transaction.RequestTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RequestService {
    @Autowired
    RequestRepository requestRepository;
    @Autowired
    UserInterfaceService userInterfaceService;
    @Autowired
    WorkflowService workflowService;
    @Autowired
    MergeService mergeService;
    @Autowired
    AuthorisationService authorisationService;



    public RequestModel getRequestDetails(Long requestId) {
        Optional<Request> request = requestRepository.findById(requestId);

        if (request.isEmpty()) {
            throw new NoDataFoundException("Request Not Found");
        } else {
            Request requestEntity = request.get();
            Optional<List<UIFieldModel>> uiInputFieldRules = userInterfaceService.getRequestDetailsUIInputFieldRules(requestEntity.getRequestType(), requestEntity.getStageType());
            Optional<List<UIFieldModel>> uiTabRules = userInterfaceService.getRequestDetailsUITabFieldRules(requestEntity.getRequestType(), requestEntity.getStageType());
            Optional<List<UIFieldModel>> uiButtonRules = userInterfaceService.getRequestDetailsUIButtonFieldRules(requestEntity.getRequestType(), requestEntity.getStageType());
            return RequestTransformer.entityToModel(requestEntity,
                    uiInputFieldRules.orElse(null),
                    uiTabRules.orElse(null),
                    uiButtonRules.orElse(null)
            );
        }
    }


    public RequestStageModel getNextRequestStage(Long requestId) {
        Optional<Request> request = requestRepository.findById(requestId);
        if (request.isEmpty()) {
            throw new NoDataFoundException("Request Not Found");
        }
        Request requestEntity = request.get();
        return workflowService.getNextStageModel(requestEntity.getRequestType(), requestEntity.getStageType(), StageActionEnum.SUCCESS.name());

    }

    public RequestModel submitRequest(RequestModel requestModel) {
        Integer userId = requestModel.requestSubmittedBy().userId();
        Optional<Request> requestOptional = requestRepository.findById(requestModel.requestId());
        if (requestOptional.isEmpty()) {
            throw new NoDataFoundException("Request Not Found");
        }
        Request requestEntity = requestOptional.get();

        // get next request stage
        Optional<StageWorkflowRules> nextStageOptional = workflowService.getNextStageEntity(requestEntity.getRequestType(), requestEntity.getStageType(), StageActionEnum.SUCCESS.name());
        if (nextStageOptional.isEmpty()) {
            throw new NoDataFoundException("Next Request Stage Not Found");
        }
        StageWorkflowRules transitStageEntity = nextStageOptional.get();

        User userEntity =  authorisationService.getUserEntity(userId).orElse(null);

        // merge data
        mergeService.mergeRequestModelWithEntity(requestEntity, requestModel, userEntity);

        // update request stage
        requestEntity.setStageType(transitStageEntity.getNextStageType());

        //save request data
        Request savedRequest = requestRepository.save(requestEntity);

        // update request stage to complete
        workflowService.updateRequestStages(savedRequest, transitStageEntity.getCurrentStageType(), transitStageEntity.getNextStageType(), userEntity);


        //TODO
        Optional<List<UIFieldModel>> uiInputFieldRules = userInterfaceService.getRequestDetailsUIInputFieldRules(requestEntity.getRequestType(), requestEntity.getStageType());
        Optional<List<UIFieldModel>> uiTabRules = userInterfaceService.getRequestDetailsUITabFieldRules(requestEntity.getRequestType(), requestEntity.getStageType());
        Optional<List<UIFieldModel>> uiButtonRules = userInterfaceService.getRequestDetailsUIButtonFieldRules(requestEntity.getRequestType(), requestEntity.getStageType());

        return RequestTransformer.entityToModel(savedRequest,
                uiInputFieldRules.orElse(null),
                uiTabRules.orElse(null),
                uiButtonRules.orElse(null)
        );

    }

}
