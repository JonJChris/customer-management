package com.management.customer.exceptions;

public class NoDataFoundException extends RuntimeException{
    public NoDataFoundException(String message) {
        super(message);
    }
    public NoDataFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
