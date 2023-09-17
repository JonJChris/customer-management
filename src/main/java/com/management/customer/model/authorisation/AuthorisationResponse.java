package com.management.customer.model.authorisation;

import com.management.customer.enums.AuthorisationRequestTypeEnum;
import com.management.customer.enums.AuthorisationResponseTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public record AuthorisationResponse(
        AuthorisationResponseTypeEnum authorisationResponseType,
        String authorisationResponseMessage,
        UserModel userModel){
}
