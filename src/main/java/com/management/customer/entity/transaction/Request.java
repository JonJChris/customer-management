package com.management.customer.entity.transaction;

import com.management.customer.entity.lookup.RequestStage;
import com.management.customer.entity.lookup.RequestType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@Entity
@Table(name="RQ_REQUEST")
public class Request {
    @Id
    @GeneratedValue
    @Column(name="REQUEST_ID")
    private Long requestId;
    @Column(name="REQUEST_TYPE")
    private RequestType requestType;
    @Column(name="REQUEST_STAGE")
    private RequestStage requestStage;
    @Column(name="CREATED_DATE")
    private LocalDateTime createdOn;
    @Column(name="CREATED_BY")
    private User createdBy;
    @Column(name="LAST_UPDATED_DATE")
    private LocalDateTime updatedOn;
    @Column(name="LAST_UPDATED_BY")
    private User updatedBy;

}
