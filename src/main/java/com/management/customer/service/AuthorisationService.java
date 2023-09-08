package com.management.customer.service;

import com.management.customer.entity.authrisation.User;
import com.management.customer.repository.authorisation.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorisationService {
    @Autowired
    UserRepository userRepository;

    Optional<User> getUserEntity(Integer userId){
        return userRepository.findById(userId);
    }

}
