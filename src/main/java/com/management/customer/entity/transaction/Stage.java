package com.management.customer.entity.transaction;

import com.management.customer.entity.authrisation.User;
import com.management.customer.entity.master.Status;
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
public class Stage {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "REQUEST_ID")
    private Request request;
    @ManyToOne
    @JoinColumn(name = "REQUEST_STAGE_ID")
    private com.management.customer.entity.master.RequestStage requestStage;
    @ManyToOne
    @JoinColumn(name = "REQUEST_STATUS_ID")
    private Status requestStatus;
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
}
