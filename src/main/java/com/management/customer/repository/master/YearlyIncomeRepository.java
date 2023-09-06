package com.management.customer.repository.master;

import com.management.customer.entity.lookup.YearlyIncome;
import org.springframework.data.jpa.repository.JpaRepository;

public interface YearlyIncomeRepository extends JpaRepository<YearlyIncome, Integer> {
}
