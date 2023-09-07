package com.management.customer.controller;

import com.management.customer.exceptions.ApplicationError;
import com.management.customer.exceptions.NoDataFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationExceptionHandler {
    @ExceptionHandler(NoDataFoundException.class)
    @ResponseBody
    public ResponseEntity<ApplicationError> catchNoDataFoundException(HttpServletRequest request, NoDataFoundException exception){
        String url = request.getRequestURI();
        ApplicationError response = new ApplicationError(url, exception.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
