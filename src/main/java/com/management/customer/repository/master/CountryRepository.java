package com.management.customer.repository.master;

import com.management.customer.entity.master.CountryType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<CountryType, Integer> {
}
