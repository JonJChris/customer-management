package com.management.customer.repository.request;

import com.management.customer.entity.transaction.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
