package com.management.customer.model.search;

public record CustomerSearchRequest(Long customerId, String firstName, String lastName, Integer nationality) {
}
