package com.management.customer.entity.transaction;

import com.management.customer.entity.authrisation.User;
import com.management.customer.entity.master.StageType;
import com.management.customer.entity.master.StatusType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "REQUEST_STAGE")
public class RequestStage {

    @Id
    @SequenceGenerator(name = "request_stage_sequence", allocationSize = 5, initialValue = 6000, sequenceName = "REQUEST_STAGE_SQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "request_stage_sequence" )
    @Column(name = "STAGE_ID")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "REQUEST")
    private Request request;
    @ManyToOne
    @JoinColumn(name = "STAGE_TYPE")
    private StageType stageType;
    @ManyToOne
    @JoinColumn(name = "STATUS_TYPE")
    private StatusType statusType;
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
