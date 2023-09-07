package com.management.customer.model.userInterface;

public record UIFieldModel(Integer fieldId, String fieldName, Boolean isVisible, Boolean isEditable, Boolean isMandatory) {
}
