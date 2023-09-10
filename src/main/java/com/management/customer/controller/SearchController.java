package com.management.customer.controller;

import com.management.customer.model.search.CustomerSearchRequest;
import com.management.customer.model.search.CustomerSearchResult;
import com.management.customer.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/search")
@CrossOrigin(origins =  {"http://localhost","http://localhost:3000"})
public class SearchController {
    @Autowired
    SearchService searchService;
    @PostMapping("customer")
    public CustomerSearchResult searchCustomer(@RequestBody CustomerSearchRequest customerSearchRequest){
        return searchService.searchCustomer(customerSearchRequest);
    }
}
