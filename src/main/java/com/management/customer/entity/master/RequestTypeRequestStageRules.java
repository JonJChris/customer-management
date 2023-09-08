package com.management.customer.entity.master;

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
    private RequestType requestStage;
    @Column(name="STAGE_ORDER")
    private Integer stageOrder;

}
