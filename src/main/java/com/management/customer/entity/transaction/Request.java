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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="REQUEST_ID")
    private Long requestId;
    @ManyToOne
    @JoinColumn(name="REQUEST_TYPE")
    private RequestType requestType;
    @ManyToOne
    @JoinColumn(name="REQUEST_STAGE")
    private StageType stageType;
    @Column(name="CREATED_DATE")
    private LocalDateTime createdOn;
    @ManyToOne
    @JoinColumn(name="CREATED_BY")
    private User createdBy;
    @Column(name="LAST_UPDATED_DATE")
    private LocalDateTime updatedOn;
    @ManyToOne
    @JoinColumn(name="LAST_UPDATED_BY")
    private User updatedBy;
    @OneToOne(mappedBy = "request")
    private RequestCustomer requestCustomer;
    @OneToOne(mappedBy = "request")
    private RequestAddress requestAddress;
    @OneToMany(mappedBy = "request")
    private List<RequestStage> requestRequestStages;

}
