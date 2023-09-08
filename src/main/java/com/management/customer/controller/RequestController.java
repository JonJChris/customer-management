package com.management.customer.controller;

import com.management.customer.model.master.RequestStageModel;
import com.management.customer.model.transaction.RequestModel;
import com.management.customer.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/request")
@CrossOrigin(origins = "http://localhost:3000")

public class RequestController {
    @Autowired
    RequestService requestService;
    @GetMapping("{requestId}")
    public RequestModel getRequestDetails(@PathVariable("requestId") Long requestId){
        return requestService.getRequestDetails(requestId);
    }

    @GetMapping("{requestId}/nextStage")
    public RequestStageModel getNextRequestStage(@PathVariable("requestId") Long requestId){
        return requestService.getNextRequestStage(requestId);

    }
    @PutMapping("{requestId}")
    public RequestModel submitRequest(@PathVariable Long requestId, @RequestBody RequestModel requestModel){
      return  requestService.submitRequest(requestModel);
    }
}
