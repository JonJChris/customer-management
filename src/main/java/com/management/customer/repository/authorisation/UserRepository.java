package com.management.customer.repository.authorisation;

import com.management.customer.entity.authrisation.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    public Optional<User> findByUserName(@Param("userName") String userName);
}
