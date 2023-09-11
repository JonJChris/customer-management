package com.management.customer.entity.ui;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "UI_FIELD_LIST")

public class UserInterfaceField {
    @Id
    @Column(name="ID")
    private Integer id;
    @Column(name="FIELD_NAME")
    private String fieldName;
    @Column(name="FIELD_DISPLAY_NAME")
    private String fieldDisplayName;
    @Column(name="FIELD_TYPE")
    private String fieldType;
    @Column(name="FIELD_TAB")
    private String fieldTab;
    @Column(name="FIELD_ORDER")
    private Integer fieldOrder;
    @Column(name="FIELD_LINK")
    private String fieldLink;
    @Column(name="FIELD_AREA")
    private String fieldArea;

}
