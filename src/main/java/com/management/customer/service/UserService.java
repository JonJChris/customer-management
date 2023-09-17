package com.management.customer.service;

import com.management.customer.entity.authrisation.User;
import com.management.customer.enums.AuthorisationResponseTypeEnum;
import com.management.customer.model.authorisation.AuthorisationRequest;
import com.management.customer.model.authorisation.AuthorisationResponse;
import com.management.customer.model.authorisation.UserModel;
import com.management.customer.repository.authorisation.UserRepository;
import com.management.customer.tranformer.transaction.UserTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {

    public static final User GENERAL_USER =
            new User(25002, "robinjackson", "Robin", "Jackson", "robin.jackson@gmail.com", "Japan", "password", true, false);


    @Autowired
    UserRepository userRepository;


    public AuthorisationResponse loginUser(AuthorisationRequest authorisationRequest) {
        AuthorisationResponse response = null;
        if (Objects.isNull(authorisationRequest) || Objects.isNull(authorisationRequest.userName()) || Objects.isNull(authorisationRequest.password())) {
            response = new AuthorisationResponse(
                    AuthorisationResponseTypeEnum.LOGIN_FAILED,
                    "Invalid Username or password",
                    null);
        } else {
            Optional<User> userOptional = userRepository.findByUserName(authorisationRequest.userName());
            if (userOptional.isEmpty()) {
                response = new AuthorisationResponse(
                        AuthorisationResponseTypeEnum.LOGIN_FAILED,
                        "Invalid Username",
                        null);
            } else {
                User user = userOptional.get();
                if (!user.getUserPassword().equals(authorisationRequest.password())) {
                    response = new AuthorisationResponse(
                            AuthorisationResponseTypeEnum.LOGIN_FAILED,
                            "Invalid password",
                            null);
                } else {
                    //valid username and password
                    UserModel userModel = UserTransformer.entityToModel(user);
                    response = new AuthorisationResponse(
                            AuthorisationResponseTypeEnum.LOGIN_SUCCESS,
                            "LOGIN SUCCESS",
                            userModel);
                }
            }


        }
        return response;
    }

    public AuthorisationResponse logoutUser(AuthorisationRequest authorisationRequest) {
        AuthorisationResponse response = null;
        response = new AuthorisationResponse(AuthorisationResponseTypeEnum.LOGOUT_SUCCESS, "LOGOUT SUCCESS", null);
        return response;
    }
}
