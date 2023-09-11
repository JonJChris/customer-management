package com.management.customer.model.search.request;

public record RequestItem(Long requestId, String customerFirstName, String customerLastName, String requestType) {
}
