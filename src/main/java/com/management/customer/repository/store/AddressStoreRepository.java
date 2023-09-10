package com.management.customer.repository.store;

import com.management.customer.entity.store.AddressStore;
import com.management.customer.entity.store.CustomerStore;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressStoreRepository extends JpaRepository<AddressStore, Long> {
}
