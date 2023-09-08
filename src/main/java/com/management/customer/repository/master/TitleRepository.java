package com.management.customer.repository.master;

import com.management.customer.entity.master.TitleType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TitleRepository extends JpaRepository<TitleType, Integer> {
}
