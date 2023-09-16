package com.management.customer.model.userInterface;

public record UIFieldModel(Integer fieldId, String fieldName, String fieldDisplayName, Boolean isVisible, Boolean isEditable, Boolean isMandatory, Integer fieldOrder, String fieldLink, Integer maxLength) {
}
