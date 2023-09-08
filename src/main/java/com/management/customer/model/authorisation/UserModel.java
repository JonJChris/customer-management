package com.management.customer.model.authorisation;

public record UserModel(Integer userId,
                        String username,
                        String userFirstName,
                        String userLastName
                        ) {
}
