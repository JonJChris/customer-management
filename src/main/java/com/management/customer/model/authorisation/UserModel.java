package com.management.customer.model.authorisation;

import java.util.List;

public record UserModel(Integer userId,
                        String username,
                        String userFirstName,
                        String userLastName,
                        List<UserRoleTypeModel> userRoles
                        ) {
}
