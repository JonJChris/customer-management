package com.management.customer.model.master;

public record UserInterfaceRuleModel(Integer fieldId, String fieldName, String requestType, String requestStage, Boolean isVisible, Boolean isEditable, Boolean isMandatory) {
}
