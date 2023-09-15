package com.management.customer.service;

import com.management.customer.entity.authrisation.User;
import com.management.customer.entity.master.RequestType;
import com.management.customer.entity.master.StageType;
import com.management.customer.entity.master.StatusType;
import com.management.customer.entity.transaction.*;
import com.management.customer.entity.workflow.RequestTypeRequestStageRules;
import com.management.customer.entity.workflow.StageWorkflowRules;
import com.management.customer.enums.RequestTypeEnum;
import com.management.customer.enums.StageTypeEnum;
import com.management.customer.enums.StatusTypeEnum;
import com.management.customer.model.master.RequestTypeModel;
import com.management.customer.model.master.StageTypeModel;
import com.management.customer.enums.StageActionEnum;
import com.management.customer.model.store.CustomerStoreModel;
import com.management.customer.model.transaction.request.CreateNewRequestModel;
import com.management.customer.model.transaction.request.RequestModel;
import com.management.customer.exceptions.NoDataFoundException;
import com.management.customer.model.userInterface.UIFieldModel;
import com.management.customer.repository.request.RequestRepository;
import com.management.customer.repository.request.StageRepository;
import com.management.customer.repository.workflow.RequestTypeRequestStageRulesRepository;
import com.management.customer.tranformer.transaction.RequestTransformer;
import com.management.customer.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

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
    @Autowired
    CustomerService customerService;
    @Autowired
    RequestTypeRequestStageRulesRepository requestTypeRequestStageRulesRepository;
    @Autowired
    StageRepository requestStageRepository;

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



    public StageTypeModel getNextRequestStage(Long requestId) {
        Optional<Request> request = requestRepository.findById(requestId);
        if (request.isEmpty()) {
            throw new NoDataFoundException("Request Not Found");
        }
        Request requestEntity = request.get();
        return workflowService.getNextStageModel(requestEntity.getRequestType(), requestEntity.getStageType(), StageActionEnum.SUCCESS.name());

    }


    private RequestType getRequestTypeFromString(String requestType){
        boolean validRequest = false;
        RequestTypeEnum requestTypeEnum = null;
        if(requestType != null){
            if(RequestTypeEnum.CREATE_NEW_CUSTOMER.getRequestTypeName().equals(requestType)){
                requestTypeEnum = RequestTypeEnum.CREATE_NEW_CUSTOMER;
                validRequest = true;
            } else if(RequestTypeEnum.ADDRESS_AMENDMENT.getRequestTypeName().equals(requestType)){
                requestTypeEnum = RequestTypeEnum.ADDRESS_AMENDMENT;
                validRequest = true;
            } else if(RequestTypeEnum.DOCUMENT_AMENDMENT.getRequestTypeName().equals(requestType)){
                requestTypeEnum = RequestTypeEnum.DOCUMENT_AMENDMENT;
                validRequest = true;
            } else if(RequestTypeEnum.PRODUCT_AMENDMENT.getRequestTypeName().equals(requestType)){
                requestTypeEnum = RequestTypeEnum.PRODUCT_AMENDMENT;
                validRequest = true;
            } else if(RequestTypeEnum.KYC_AMENDMENT.getRequestTypeName().equals(requestType)){
                requestTypeEnum = RequestTypeEnum.KYC_AMENDMENT;
                validRequest = true;
            } else if(RequestTypeEnum.PERIODIC_REVIEW.getRequestTypeName().equals(requestType)){
                requestTypeEnum = RequestTypeEnum.PERIODIC_REVIEW;
                validRequest = true;
            } else if(RequestTypeEnum.CUSTOMER_LIFE_CYCLE_REQUEST.getRequestTypeName().equals(requestType)){
                requestTypeEnum = RequestTypeEnum.CUSTOMER_LIFE_CYCLE_REQUEST;
                validRequest = true;
            }
        }
        if(validRequest){
            return new RequestType(requestTypeEnum.getRequestTypeCode(), requestTypeEnum.getRequestTypeName());
        }else{
            throw new NoDataFoundException("Invalid Request Type");
        }
    }


    public RequestModel createRequest(CreateNewRequestModel createNewRequestModel){
        RequestType requestType = getRequestTypeFromString(createNewRequestModel.requestType());

        CustomerStoreModel customerStoreModel = null;
        if(!RequestTypeEnum.CREATE_NEW_CUSTOMER.getRequestTypeName().equals(requestType.getRequestType())){
            if(createNewRequestModel.customerId() != null){
                customerStoreModel = customerService.getCustomerDetails(createNewRequestModel.customerId());
            }else{
                throw new NoDataFoundException("Invalid Customer ID");
            }
        }
        // prepare
        Request request = new Request();
        RequestCustomer requestCustomer = new RequestCustomer();
        RequestAddress requestAddress = new RequestAddress();
        List<RequestProductRelationship> requestProductRelationshipList = new ArrayList<>();
        List<RequestDocument> requestDocumentList = new ArrayList<>();
        List<RequestTypeRequestStageRules> StageList = requestTypeRequestStageRulesRepository.findByRequestType(requestType);
        List<RequestStage> stagesList = StageList.stream().map(item ->
                new RequestStage(null, request,
                        item.getRequestStage(),
                        new StatusType(StatusTypeEnum.PENDING.getStageId(), StatusTypeEnum.PENDING.getStageTypeName()),
                        LocalDateTime.now(),
                        UserService.GENERAL_USER,
                        LocalDateTime.now(),
                        UserService.GENERAL_USER
                )
        ).toList();
        stagesList.get(0).setStatusType( new StatusType(StatusTypeEnum.IN_PROGRESS.getStageId(), StatusTypeEnum.IN_PROGRESS.getStageTypeName()));

        // update request details
        request.setRequestType(requestType);
        request.setCreatedBy(UserService.GENERAL_USER);
        request.setCreatedDate(LocalDateTime.now());
        request.setUpdatedBy(UserService.GENERAL_USER);
        request.setUpdatedDate(LocalDateTime.now());
        request.setStageType(stagesList.get(0).getStageType());
        request.setRequestRequestStages(stagesList);
        request.setRequestCustomer(requestCustomer);
        request.setRequestAddress(requestAddress);

        mergeService.mergeCustomerStoreToRequestCustomer(customerStoreModel, requestCustomer, request, UserService.GENERAL_USER);
        mergeService.mergeAddressStoreToRequestCustomer(customerStoreModel != null ? customerStoreModel.addressStoreModel() : null, requestAddress, request, UserService.GENERAL_USER);
        mergeService.mergeProductStoreListToRequestProductsList(customerStoreModel != null ? customerStoreModel.productStoreModelList():null, requestProductRelationshipList, request, UserService.GENERAL_USER);
        mergeService.mergeDocumentStoreListToRequestDocumentsList(customerStoreModel != null ? customerStoreModel.documentStoreModelsList():null,requestDocumentList, request, UserService.GENERAL_USER);


        Request savedRequest = requestRepository.save(request);
        List<RequestStage> stages = requestStageRepository.saveAll(stagesList);

        Optional<List<UIFieldModel>> uiInputFieldRules = userInterfaceService.getRequestDetailsUIInputFieldRules(savedRequest.getRequestType(), savedRequest.getStageType());
        Optional<List<UIFieldModel>> uiTabRules = userInterfaceService.getRequestDetailsUITabFieldRules(savedRequest.getRequestType(), savedRequest.getStageType());
        Optional<List<UIFieldModel>> uiButtonRules = userInterfaceService.getRequestDetailsUIButtonFieldRules(savedRequest.getRequestType(), savedRequest.getStageType());
        return RequestTransformer.entityToModel(savedRequest,
                uiInputFieldRules.orElse(null),
                uiTabRules.orElse(null),
                uiButtonRules.orElse(null)
        );
    }


    public RequestModel submitRequest(RequestModel requestModel, boolean submitToNextStage) {
        // fetch request
        Integer userId = requestModel.requestSubmittedBy().userId();
        Optional<Request> requestOptional = requestRepository.findById(requestModel.requestId());
        if (requestOptional.isEmpty()) {
            throw new NoDataFoundException("Request Not Found");
        }
        Request requestEntity = requestOptional.get();

        // fetch user details
        User userEntity = authorisationService.getUserEntity(userId).orElse(null);

        // merge data
        mergeService.mergeRequestModelWithEntity(requestEntity, requestModel, userEntity);

        //save request data
        Request savedRequest = requestRepository.save(requestEntity);
        Optional<StageWorkflowRules> dummy = workflowService.getNextStageEntity(requestEntity.getRequestType(), requestEntity.getStageType(), StageActionEnum.SUCCESS.name());
        if(StageTypeEnum.CLOSED.getStatusTypeCode() != requestEntity.getStageType().getId() // Non-Closed Request only
                && submitToNextStage){

            // get next request stage
            Optional<StageWorkflowRules> nextStageOptional = workflowService.getNextStageEntity(requestEntity.getRequestType(), requestEntity.getStageType(), StageActionEnum.SUCCESS.name());

                boolean updateNextStage = nextStageOptional.get().getNextStageType() != null;
                StageWorkflowRules transitStageEntity = nextStageOptional.get();
                // update request stage
                requestEntity.setStageType(transitStageEntity.getNextStageType());
                // update request stage to complete
                workflowService.updateRequestStages(true, updateNextStage, savedRequest, transitStageEntity.getCurrentStageType(), transitStageEntity.getNextStageType(), userEntity);
            customerService.persistDataCustomerStore(savedRequest);
        }

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
