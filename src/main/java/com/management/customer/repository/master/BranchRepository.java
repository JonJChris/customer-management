package com.management.customer.repository.master;

import com.management.customer.entity.master.Branch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BranchRepository extends JpaRepository<Branch, Integer> {
}
