package com.management.customer.repository.master;

import com.management.customer.entity.lookup.UIFieldRules;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInterfaceRulesRepository extends JpaRepository<UIFieldRules, Integer> {
}
