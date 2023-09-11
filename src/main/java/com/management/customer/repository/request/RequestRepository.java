package com.management.customer.repository.request;

import com.management.customer.entity.transaction.Request;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RequestRepository extends JpaRepository<Request, Long> {

    public Optional<List<Request>> findByRequestCustomer_CustomerId(Long customerId);

}
