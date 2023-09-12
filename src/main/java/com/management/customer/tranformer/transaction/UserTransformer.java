package com.management.customer.tranformer.transaction;

import com.management.customer.model.authorisation.UserModel;
import com.management.customer.entity.authrisation.User;

public class UserTransformer {
    public static UserModel entityToModel(User user){
            return new UserModel(user.getId(), user.getUserName(), user.getUserFirstName(), user.getUserLastName());
        }

}
