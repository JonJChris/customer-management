package com.management.customer.entity.master;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "STAGE_WORKFLOW_RULES")
public class StageWorkflowRules {
    @Id
    @Column(name="ID")
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name="REQUEST_TYPE_ID")
    private RequestType requestType;
    @ManyToOne
    @JoinColumn(name="CURRENT_REQUEST_STAGE_ID")
    private StageType currentStageType;
    @Column(name="STAGE_ACTION")
    private String stageAction;
    @ManyToOne
    @JoinColumn(name="NEXT_REQUEST_STAGE_ID")
    private StageType nextStageType;

}
