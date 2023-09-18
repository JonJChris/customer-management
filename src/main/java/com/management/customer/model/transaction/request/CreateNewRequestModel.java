package com.management.customer.model.transaction.request;

public record CreateNewRequestModel(Long customerId, String firstName, String lastName, Integer nationality, String requestType, Integer requestSubmittedBy ) {
}
