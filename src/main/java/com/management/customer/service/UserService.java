package com.management.customer.service;

import com.management.customer.entity.authrisation.User;
import com.management.customer.entity.master.StageType;
import com.management.customer.enums.AuthorisationResponseTypeEnum;
import com.management.customer.enums.UserRoleTypeEnum;
import com.management.customer.exceptions.NoDataFoundException;
import com.management.customer.model.authorisation.AuthorisationRequest;
import com.management.customer.model.authorisation.AuthorisationResponse;
import com.management.customer.model.authorisation.UserModel;
import com.management.customer.model.transaction.request.UserPermissionModel;
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

    public UserPermissionModel getUserPermission(Integer userId, StageType stageType){
        Optional<User> userOptional = userRepository.findById(userId);

        if(userOptional.isEmpty()){
            throw new NoDataFoundException("User Not Found");
        }else{
            User user = userOptional.get();
            boolean canCreateNewCustomer = user.getUserRolesList().stream().anyMatch(role -> UserRoleTypeEnum.CREATE_NEW_CUSTOMER.name().equals(role.getUserRoleName()));
            boolean canManageCustomer = user.getUserRolesList().stream().anyMatch(role -> UserRoleTypeEnum.MANAGE_CUSTOMER.name().equals(role.getUserRoleName()));
            boolean canEditState = user.getUserRolesList().stream().anyMatch(role -> stageType.getStagePermission().equals(role.getId()));
            return new UserPermissionModel(canCreateNewCustomer, canManageCustomer, canEditState);
        }
    }
}
