package com.management.customer.model.search;

import java.util.List;

public record CustomerSearchResult(String message, List<CustomerItem> customerItemList) {
}
