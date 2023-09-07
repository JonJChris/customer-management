package com.management.customer.repository.master;

import com.management.customer.entity.master.Profession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessionRepository extends JpaRepository<Profession, Integer> {
}
