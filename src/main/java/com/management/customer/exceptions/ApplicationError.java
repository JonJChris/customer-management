package com.management.customer.exceptions;

import org.springframework.http.HttpStatus;

public record ApplicationError(String requestURL, String errorMessage, HttpStatus httpStatus) {
}
