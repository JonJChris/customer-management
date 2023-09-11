package com.management.customer.model.search.customer;

import java.util.List;

public record CustomerSearchResult(String message, List<CustomerItem> customerItemList) {
}
