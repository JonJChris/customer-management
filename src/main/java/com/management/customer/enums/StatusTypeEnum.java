package com.management.customer.enums;

import lombok.Getter;

@Getter
public enum StatusTypeEnum {
    IN_PROGRESS(26000, "IN_PROGRESS"),
    PENDING(26001, "PENDING"),
    COMPLETE(26002, "COMPLETE");
    private final int stageId;
    private final String stageTypeName;

    StatusTypeEnum(int stageId, String stageTypeName) {
        this.stageId = stageId;
        this.stageTypeName = stageTypeName;
    }
}
