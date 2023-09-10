package com.management.customer.repository.store;

import com.management.customer.entity.store.CustomerStore;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerStoreRepository extends JpaRepository<CustomerStore, Long> {
}
