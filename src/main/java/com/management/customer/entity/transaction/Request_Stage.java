package com.management.customer.entity.transaction;

import com.management.customer.entity.lookup.RequestStage;
import com.management.customer.entity.lookup.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "REQUEST_STAGE")
public class Request_Stage {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;
    @Column(name = "REQUEST_ID")
    private Request request;
    @Column(name = "REQUEST_STAGE_ID")
    private RequestStage requestStage;
    @Column(name = "REQUEST_STATUS_ID")
    private Status requestStatus;
    @Column(name = "CREATED_DATE")
    private LocalDateTime createdOn;
    @Column(name = "CREATED_BY")
    private User createdBy;
    @Column(name = "LAST_UPDATED_DATE")
    private LocalDateTime updatedOn;
    @Column(name = "LAST_UPDATED_BY")
    private User updatedBy;
}
