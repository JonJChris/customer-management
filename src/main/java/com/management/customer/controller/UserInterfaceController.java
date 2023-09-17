package com.management.customer.controller;

import com.management.customer.entity.master.RequestType;
import com.management.customer.entity.master.StageType;
import com.management.customer.exceptions.NoDataFoundException;
import com.management.customer.model.userInterface.UIFieldModel;
import com.management.customer.model.userInterface.UserInterfaceFieldRequest;
import com.management.customer.service.UserInterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/userInterface")
@CrossOrigin(origins = {"http://localhost:3000"})
public class UserInterfaceController {
    @Autowired
    UserInterfaceService userInterfaceService;
    @GetMapping("field")
    public List<UIFieldModel> getUIInputFieldForRequestAndStage(Integer requestType, Integer stageType){
        if(requestType!= null && stageType != null){
            Optional<List<UIFieldModel>> requestDetailsUIInputFieldRules = userInterfaceService.getRequestDetailsUIInputFieldRules(new RequestType(requestType, null), new StageType(stageType, null));
            return requestDetailsUIInputFieldRules.orElse(null);
        }else{
            throw new NoDataFoundException("Invalid Request Type or Request Stage");
        }

    }
    @GetMapping("button")
    public List<UIFieldModel> getUIButtonForRequestAndStage(Integer requestType, Integer stageType){
        if(requestType!= null && stageType != null){
            Optional<List<UIFieldModel>> requestDetailsUIInputFieldRules = userInterfaceService.getRequestDetailsUIButtonFieldRules(new RequestType(requestType, null), new StageType(stageType, null));
            return requestDetailsUIInputFieldRules.orElse(null);
        }else{
            throw new NoDataFoundException("Invalid Request Type or Request Stage");
        }

    }
    @GetMapping("tab")
    public List<UIFieldModel> getUITabForRequestAndStage(Integer requestType, Integer stageType){
        if(requestType!= null && stageType != null){
            Optional<List<UIFieldModel>> requestDetailsUIInputFieldRules = userInterfaceService.getRequestDetailsUITabFieldRules(new RequestType(requestType, null), new StageType(stageType, null));
            return requestDetailsUIInputFieldRules.orElse(null);
        }else{
            throw new NoDataFoundException("Invalid Request Type or Request Stage");
        }

    }
}
