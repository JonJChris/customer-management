package com.management.customer.repository.master;

import com.management.customer.entity.lookup.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Integer> {
}
