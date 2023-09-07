package com.management.customer.entity.master;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "UI_FIELD_RULES")
public class UIFieldRules {
    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name="REQUEST_TYPE_ID")
    private RequestType requestTypeId;
    @ManyToOne
    @JoinColumn(name="REQUEST_STAGE_ID")
    private RequestStage requestStageId;
    @ManyToOne
    @JoinColumn(name="FIELD_ID")
    private UIFiled uiFiled;
    @Column(name="IS_VISIBLE")
    private Boolean isVisible;
    @Column(name="IS_EDITABLE")
    private Boolean isEditable;
    @Column(name="IS_MANDATORY")
    private Boolean isMandatory;


}
