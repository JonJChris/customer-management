package com.management.customer.repository.master;

import com.management.customer.entity.lookup.HomeOwnershipType;
import com.management.customer.entity.lookup.RequestStage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HomeOwnershipTypeRepository extends JpaRepository<HomeOwnershipType, Integer> {
}
