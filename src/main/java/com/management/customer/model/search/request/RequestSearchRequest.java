package com.management.customer.model.search.request;

public record RequestSearchRequest(Long requestId, String customerFirstName, String customerLastName, Integer requestType) {
}
