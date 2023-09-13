package com.management.customer.enums;

import lombok.Getter;

@Getter
public enum RequestTypeEnum {
    CREATE_NEW_CUSTOMER(11000, "Create New Customer"),
    ADDRESS_AMENDMENT(11001, "Address Amendment"),
    KYC_AMENDMENT(11002, "KYC Amendment"),
    PRODUCT_AMENDMENT(11003, "Product Amendment"),
    DOCUMENT_AMENDMENT(11004, "Document Amendment"),
    PERIODIC_REVIEW(11005, "Periodic Review"),
    CUSTOMER_LIFE_CYCLE_REQUEST(11006, "Customer Lifecycle Request");



    private int requestTypeCode;
    private String requestTypeName;
    RequestTypeEnum(int requestTypeCode, String requestTypeName) {
        this.requestTypeCode = requestTypeCode;
        this.requestTypeName = requestTypeName;
    }
}
