package com.management.customer.model.master;

import java.util.List;

public record BranchModel(Integer branchId, String branchCode, String branchName, String branchDescription, List<ProductModel> productsList) {
}
