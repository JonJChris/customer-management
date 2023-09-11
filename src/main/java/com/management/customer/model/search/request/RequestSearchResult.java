package com.management.customer.model.search.request;

import java.util.List;

public record RequestSearchResult(String message, List<RequestItem> requestItemList) {
}
