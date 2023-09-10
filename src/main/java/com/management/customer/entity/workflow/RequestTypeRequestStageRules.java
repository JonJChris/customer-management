package com.management.customer.entity.workflow;

import com.management.customer.entity.master.RequestType;
import com.management.customer.entity.master.StageType;
import com.management.customer.entity.transaction.RequestStage;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "REQUEST_TYPE_REQUEST_STAGE_RULES")
public class RequestTypeRequestStageRules {
    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name="REQUEST_TYPE_ID")
    private RequestType requestType;
    @ManyToOne
    @JoinColumn(name="REQUEST_STAGE_ID")
    private StageType requestStage;
    @Column(name="STAGE_ORDER")
    private Integer stageOrder;

}
