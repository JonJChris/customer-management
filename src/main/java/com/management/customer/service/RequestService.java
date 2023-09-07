package com.management.customer.service;

import com.management.customer.model.transaction.RequestModel;
import com.management.customer.entity.transaction.Request;
import com.management.customer.exceptions.NoDataFoundException;
import com.management.customer.model.userInterface.UIFieldModel;
import com.management.customer.repository.master.UserInterfaceRulesRepository;
import com.management.customer.repository.request.RequestRepository;
import com.management.customer.tranformer.RequestTransformer;
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
    public RequestModel getRequestDetails(Long requestId){
        Optional<Request> request = requestRepository.findById(requestId);

        if(request.isEmpty()){
            throw  new NoDataFoundException("Request Not Found");
        }else{
            Request requestEntity = request.get();
            Optional<List<UIFieldModel>> uiFieldRules = userInterfaceService.getUIFieldRules(requestEntity.getRequestType(), requestEntity.getRequestStage());
            return RequestTransformer.entityToModel(requestEntity, uiFieldRules.orElse(null));
        }
    }
}
