package com.management.customer.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
public class IndexController implements ErrorController {
    private final static String PATH = "/error";

    @RequestMapping(PATH)
    @ResponseBody
    public ResponseEntity<Void> getErrorPath() {
        // TODO Auto-generated method stub
        System.out.println("Redirecting to home page.. ");
        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create("/")).build();
    }

}
