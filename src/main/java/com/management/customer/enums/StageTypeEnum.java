package com.management.customer.enums;

public enum StageTypeEnum {
    COLLECT_KYC(19000, "Collect KYC"),
    UPDATE_PRODUCTS(19001, "Update Products"),
    UPDATE_ADDRESS(19002, "Update Address"),
    UPDATE_DOCUMENTS(19003, "update Documents"),
    REVIEW_AND_SUBMIT(19004, "Review and Submit"),
    MANAGER_APPROVAL(19005, "Manager Approval"),

    CLOSED(19006, "Closed"),
    UPDATE_CUSTOMER_STATUS(19006, "Update Customer Status");


    private int statusTypeCode;
    private String statusTypeName;
    StageTypeEnum(int statusTypeCode, String statusTypeName) {
        this.statusTypeCode = statusTypeCode;
        this.statusTypeName = statusTypeName;
    }
}



