package com.management.customer.model.transaction.request;

public record UserPermissionModel(Boolean canCreateNewCustomer, Boolean canManageCustomer, Boolean canEditStage) {
}
