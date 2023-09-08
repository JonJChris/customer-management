package com.management.customer.repository.master;

import com.management.customer.entity.master.BranchType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BranchRepository extends JpaRepository<BranchType, Integer> {
}
