package com.management.customer.dto;

public record UserInterfaceRuleDTO(Integer fieldId, String fieldName, String requestType, String requestStage, Boolean isVisible, Boolean isEditable, Boolean isMandatory) {
}
