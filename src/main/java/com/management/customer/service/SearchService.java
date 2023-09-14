package com.management.customer.service;

import com.management.customer.builder.CustomerSearchBuilder;
import com.management.customer.builder.RequestSearchBuilder;
import com.management.customer.entity.store.CustomerStore;
import com.management.customer.entity.transaction.Request;
import com.management.customer.model.search.customer.CustomerItem;
import com.management.customer.model.search.customer.CustomerSearchRequest;
import com.management.customer.model.search.customer.CustomerSearchResult;
import com.management.customer.model.search.request.RequestItem;
import com.management.customer.model.search.request.RequestSearchRequest;
import com.management.customer.model.search.request.RequestSearchResult;
import com.management.customer.repository.request.RequestRepository;
import com.management.customer.repository.store.CustomerStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.management.customer.utils.StringUtils.*;

@Service
public class SearchService {
    @Autowired
    CustomerStoreRepository  customerStoreRepository;
    @Autowired
    RequestRepository requestRepository;
    public CustomerSearchResult searchCustomer(CustomerSearchRequest customerSearchRequest) {
        CustomerSearchBuilder builder = getCustomerStoreBuilder(customerSearchRequest);
        CustomerStore customerStore = builder.build();
        Pageable topTenRecords = PageRequest.of(0, 10, Sort.Direction.ASC, "customerId");

//        Page<CustomerStore> customerStoreList = customerStoreRepository.findAll(topTenRecords);
        Page<CustomerStore> customerStoreList = customerStoreRepository.findAll(Example.of(customerStore), topTenRecords);
        List<CustomerItem> customerItemList = customerStoreList.stream()
                .map(item -> new CustomerItem(item.getCustomerId(), item.getFirstname(), item.getLastName(),
                        item.getNationality() != null ? item.getNationality().getCountryName() : null
                ))
                .toList();
        return new CustomerSearchResult("Fetching only top 10 results", customerItemList);
    }

    private static CustomerSearchBuilder getCustomerStoreBuilder(CustomerSearchRequest customerSearchRequest) {
        CustomerSearchBuilder builder = new CustomerSearchBuilder();
        if(!isNullOrEmptyLong(customerSearchRequest.customerId())){
            builder.customerId(customerSearchRequest.customerId());
        }
        if(!isNullOrEmptyString(customerSearchRequest.firstName())){
            builder.firstName(customerSearchRequest.firstName());
        }
        if(!isNullOrEmptyString(customerSearchRequest.lastName())){
            builder.lastName(customerSearchRequest.lastName());
        }
        if(!isNullOrEmptyInteger(customerSearchRequest.nationality())){
            builder.nationality(customerSearchRequest.nationality());
        }
        return builder;
    }


    public RequestSearchResult searchRequest(RequestSearchRequest requestSearchRequest) {
        RequestSearchBuilder builder = getRequestSearchBuilder(requestSearchRequest);
        Request requestEntity = builder.build();
        Pageable topTenRecords = PageRequest.of(0, 10, Sort.Direction.ASC, "requestId");

//        Page<CustomerStore> customerStoreList = customerStoreRepository.findAll(topTenRecords);
        Page<Request> requestsList = requestRepository.findAll(Example.of(requestEntity), topTenRecords);
        List<RequestItem> requestItemList = requestsList.stream()
                .map(item -> new RequestItem(item.getRequestId(), item.getRequestCustomer().getFirstname(), item.getRequestCustomer().getLastName(), item.getRequestType().getRequestType()))
                .toList();
        return new RequestSearchResult("Fetching only top 10 results", requestItemList);
    }

    private static RequestSearchBuilder getRequestSearchBuilder(RequestSearchRequest requestSearchRequest) {
        RequestSearchBuilder builder = new RequestSearchBuilder();
        if(!isNullOrEmptyLong(requestSearchRequest.requestId())){
            builder.requestId(requestSearchRequest.requestId());
        }
        if(!isNullOrEmptyString(requestSearchRequest.customerFirstName())){
            builder.customerFirstName(requestSearchRequest.customerFirstName());
        }
        if(!isNullOrEmptyString(requestSearchRequest.customerLastName())){
            builder.customerLastName(requestSearchRequest.customerLastName());
        }
        if(!isNullOrEmptyInteger(requestSearchRequest.requestType())){
            builder.requestType(requestSearchRequest.requestType());
        }
        return builder;
    }
}
