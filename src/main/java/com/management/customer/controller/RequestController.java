package com.management.customer.controller;

import com.management.customer.model.master.StageTypeModel;
import com.management.customer.model.transaction.request.CreateNewRequestModel;
import com.management.customer.model.transaction.request.RequestModel;
import com.management.customer.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/request")
@CrossOrigin(origins = {"http://localhost:3000"})

public class RequestController {
    @Autowired
    RequestService requestService;
    @PutMapping("{requestId}")
    public RequestModel getRequestDetails(@PathVariable("requestId") Long requestId, @RequestBody RequestModel requestModel){
        return requestService.getRequestDetails(requestId, requestModel);
    }

    @PutMapping("{requestId}/nextStage")
    public StageTypeModel getNextRequestStage(@PathVariable("requestId") Long requestId, @RequestBody RequestModel requestModel){
        return requestService.getNextRequestStage(requestId, requestModel);

    }
    @PutMapping("{requestId}/submit")
    public RequestModel submitRequest(@PathVariable Long requestId, @RequestBody RequestModel requestModel){
      return  requestService.submitRequest(requestModel, true, false);
    }

    @PutMapping("{requestId}/rework")
    public RequestModel reworkRequest(@PathVariable Long requestId, @RequestBody RequestModel requestModel){
        return  requestService.submitRequest(requestModel, true, true);
    }
    @PutMapping("{requestId}/save")
    public RequestModel saveRequest(@PathVariable Long requestId, @RequestBody RequestModel requestModel){
        return  requestService.submitRequest(requestModel, false ,false);
    }
    @PostMapping("new")
    public RequestModel createRequest(@RequestBody CreateNewRequestModel createNewRequestModel){
        return  requestService.createRequest(createNewRequestModel);
    }
}
