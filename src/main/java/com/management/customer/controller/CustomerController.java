package com.management.customer.controller;

import com.management.customer.model.master.RequestStageModel;
import com.management.customer.model.transaction.request.RequestModel;
import com.management.customer.model.transaction.store.CustomerStoreModel;
import com.management.customer.service.CustomerService;
import com.management.customer.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer")
@CrossOrigin(origins = "http://localhost:3000")
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @GetMapping("{customerId}")
    public CustomerStoreModel getCustomerDetails(@PathVariable("customerId") Long customerId){
        return customerService.getCustomerDetails(customerId);
    }

}
