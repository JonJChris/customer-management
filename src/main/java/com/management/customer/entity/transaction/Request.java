package com.management.customer.entity.transaction;

import com.management.customer.entity.authrisation.User;
import com.management.customer.entity.master.StageType;
import com.management.customer.entity.master.RequestType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name="RQ_REQUEST")
public class Request {
    @Id
    @SequenceGenerator(name = "rq_request_sequence", allocationSize = 5, initialValue = 10000, sequenceName = "RQ_REQUEST_SQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rq_request_sequence" )
    @Column(name="REQUEST_ID")
    private Long requestId;
    @ManyToOne
    @JoinColumn(name="REQUEST_TYPE")
    private RequestType requestType;
    @ManyToOne
    @JoinColumn(name="REQUEST_STAGE")
    private StageType stageType;
    @OneToOne(mappedBy = "request", cascade = CascadeType.ALL, orphanRemoval = true)
    private RequestCustomer requestCustomer;
    @OneToOne(mappedBy = "request", cascade = CascadeType.ALL, orphanRemoval = true)
    private RequestAddress requestAddress;
    @OneToMany(mappedBy = "request", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RequestProductRelationship> productRelationshipList;
    @OneToMany(mappedBy = "request", cascade =  CascadeType.ALL, orphanRemoval = true)
    private List<RequestDocument> documentListList;
    @OneToMany(mappedBy = "request")
    private List<RequestStage> requestRequestStages;
    @Column(name="CREATED_DATE")
    private LocalDateTime createdDate;
    @ManyToOne
    @JoinColumn(name="CREATED_BY")
    private User createdBy;
    @Column(name="UPDATED_DATE")
    private LocalDateTime updatedDate;
    @ManyToOne
    @JoinColumn(name="UPDATED_BY")
    private User updatedBy;

}
