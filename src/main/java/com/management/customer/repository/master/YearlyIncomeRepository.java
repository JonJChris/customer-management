package com.management.customer.repository.master;

import com.management.customer.entity.master.YearlyIncomeType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface YearlyIncomeRepository extends JpaRepository<YearlyIncomeType, Integer> {
}
