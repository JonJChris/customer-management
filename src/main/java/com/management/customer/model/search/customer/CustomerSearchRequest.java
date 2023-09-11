package com.management.customer.model.search.customer;

public record CustomerSearchRequest(Long customerId, String firstName, String lastName, Integer nationality) {
}
