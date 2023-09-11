package com.management.customer.entity.ui;

import com.management.customer.entity.master.RequestType;
import com.management.customer.entity.master.StageType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "UI_FIELD_RULES")
public class UiFieldRules {
    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name="REQUEST_TYPE_ID")
    private RequestType requestTypeId;
    @ManyToOne
    @JoinColumn(name="REQUEST_STAGE_ID")
    private StageType stageTypeId;
    @ManyToOne
    @JoinColumn(name="FIELD_ID")
    private UserInterfaceField userInterfaceField;
    @Column(name="IS_VISIBLE")
    private Boolean isVisible;
    @Column(name="IS_EDITABLE")
    private Boolean isEditable;
    @Column(name="IS_MANDATORY")
    private Boolean isMandatory;


}
