package com.management.customer.model.authorisation;

import com.management.customer.enums.AuthorisationRequestTypeEnum;

public record AuthorisationRequest(String userName, String password){
}
