package com.management.customer.controller;

import com.management.customer.model.authorisation.AuthorisationRequest;
import com.management.customer.model.authorisation.AuthorisationResponse;
import com.management.customer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("api/auth")
@CrossOrigin(origins = {"http://localhost:3000"})
public class UserController {
    @Autowired
    UserService userService;


    @PostMapping("login")
    public AuthorisationResponse loginUser(@RequestBody AuthorisationRequest authorisationRequest){
        return userService.loginUser(authorisationRequest);
    }
    @PostMapping("logout")
    public AuthorisationResponse logoutUser(@RequestBody AuthorisationRequest authorisationRequest){
        return userService.logoutUser(authorisationRequest);
    }



}
