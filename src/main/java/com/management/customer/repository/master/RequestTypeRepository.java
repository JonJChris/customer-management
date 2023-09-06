package com.management.customer.repository.master;

import com.management.customer.entity.lookup.RequestStage;
import com.management.customer.entity.lookup.RequestType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestTypeRepository extends JpaRepository<RequestType, Integer> {
}
