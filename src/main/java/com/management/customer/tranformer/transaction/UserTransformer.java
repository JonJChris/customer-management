package com.management.customer.tranformer.transaction;

import com.management.customer.model.authorisation.UserModel;
import com.management.customer.entity.authrisation.User;
import com.management.customer.model.authorisation.UserRoleTypeModel;

public class UserTransformer {
    public static UserModel entityToModel(User user) {
        return new UserModel(user.getId(), user.getUserName(), user.getUserFirstName(), user.getUserLastName(),
                user.getUserRolesList() != null ?
                        user.getUserRolesList().stream().map(item -> new UserRoleTypeModel(item.getId(), item.getUserRoleName())).toList() : null);

    }

}
