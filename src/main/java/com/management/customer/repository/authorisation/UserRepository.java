package com.management.customer.repository.authorisation;

import com.management.customer.entity.authrisation.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
