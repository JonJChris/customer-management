package com.management.customer.service;

import com.management.customer.entity.authrisation.User;
import jakarta.persistence.Column;
import jakarta.persistence.Id;

public class UserService {

    public  static final User GENERAL_USER =
            new  User(25002, "robinjackson", "Robin", "Jackson", "robin.jackson@gmail.com", "Japan", "password", true, false);

}
