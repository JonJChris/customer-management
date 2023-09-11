package com.management.customer.service;

import com.management.customer.entity.authrisation.User;
import com.management.customer.entity.store.CustomerStore;
import com.management.customer.entity.transaction.Request;
import com.management.customer.entity.workflow.StageWorkflowRules;
import com.management.customer.enums.StageActionEnum;
import com.management.customer.exceptions.NoDataFoundException;
import com.management.customer.model.master.RequestStageModel;
import com.management.customer.model.transaction.request.RequestModel;
import com.management.customer.model.transaction.store.CustomerStoreModel;
import com.management.customer.model.userInterface.UIFieldModel;
import com.management.customer.repository.request.RequestRepository;
import com.management.customer.repository.store.CustomerStoreRepository;
import com.management.customer.tranformer.CustomerStoreTransformer;
import com.management.customer.tranformer.RequestTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    CustomerStoreRepository customerStoreRepository;
    @Autowired
    RequestRepository requestRepository;

    public CustomerStoreModel getCustomerDetails(Long customerId) {
        Optional<CustomerStore> customer = customerStoreRepository.findById(customerId);
        if (customer.isEmpty()) {
            throw new NoDataFoundException("Customer Not Found");
        } else {
            CustomerStore customerEntity = customer.get();
            Optional<List<Request>> requestListOptional = requestRepository.findByRequestCustomer_CustomerId(customerEntity.getCustomerId());
            return CustomerStoreTransformer.entityToModel(customerEntity, requestListOptional.orElse(Collections.emptyList()));
        }
    }
}
