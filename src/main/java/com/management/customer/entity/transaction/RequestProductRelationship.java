package com.management.customer.entity.transaction;

import com.management.customer.entity.authrisation.User;
import com.management.customer.entity.master.BranchType;
import com.management.customer.entity.master.CountryType;
import com.management.customer.entity.master.ProductType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name="RQ_PRODUCT_RELATIONSHIP")
public class RequestProductRelationship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Long id;
    @Column(name="PRODUCT_ID")
    private Long productId;
    @Column(name="ACCOUNT_ID")
    private String accountId;
    @ManyToOne
    @JoinColumn(name="REQUEST_ID")
    private Request request;
    @ManyToOne
    @JoinColumn(name="PRODUCT_TYPE_ID")
    private ProductType productType;
    @ManyToOne
    @JoinColumn(name="BRANCH_TYPE_ID")
    private BranchType branchType;
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
