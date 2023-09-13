package com.management.customer.controller;

import com.management.customer.model.store.CustomerStoreModel;
import com.management.customer.service.CustomerService;
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
