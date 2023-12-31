package com.management.customer.repository.request;

import com.management.customer.entity.transaction.RequestAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<RequestAddress, Long> {
}
