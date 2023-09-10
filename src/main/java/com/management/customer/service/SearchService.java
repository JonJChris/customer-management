package com.management.customer.service;

import com.management.customer.builder.CustomerStoreBuilder;
import com.management.customer.entity.store.CustomerStore;
import com.management.customer.model.search.CustomerItem;
import com.management.customer.model.search.CustomerSearchRequest;
import com.management.customer.model.search.CustomerSearchResult;
import com.management.customer.repository.request.CustomerRepository;
import com.management.customer.repository.store.CustomerStoreRepository;
import com.management.customer.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

import static com.management.customer.utils.StringUtils.*;

@Service
public class SearchService {
    @Autowired
    CustomerStoreRepository  customerStoreRepository;
    public CustomerSearchResult searchCustomer(CustomerSearchRequest customerSearchRequest) {
        CustomerStoreBuilder builder = getCustomerStoreBuilder(customerSearchRequest);
        CustomerStore customerStore = builder.build();
        Pageable topTenRecords = PageRequest.of(0, 10, Sort.Direction.ASC, "customerId");

//        Page<CustomerStore> customerStoreList = customerStoreRepository.findAll(topTenRecords);
        Page<CustomerStore> customerStoreList = customerStoreRepository.findAll(Example.of(customerStore), topTenRecords);
        List<CustomerItem> list = customerStoreList.stream()
                .map(item -> new CustomerItem(item.getCustomerId(), item.getFirstname(), item.getLastName(), item.getNationality().getCountryName()))
                .toList();
        return new CustomerSearchResult("Fetching only top 10 results", list);
    }

    private static CustomerStoreBuilder getCustomerStoreBuilder(CustomerSearchRequest customerSearchRequest) {
        CustomerStoreBuilder builder = new CustomerStoreBuilder();
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


}
