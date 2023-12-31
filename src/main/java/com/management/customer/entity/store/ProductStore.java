package com.management.customer.entity.store;

import com.management.customer.entity.authrisation.User;
import com.management.customer.entity.master.BranchType;
import com.management.customer.entity.master.ProductType;
import com.management.customer.entity.transaction.Request;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name="PRODUCT_STORE")
public class ProductStore {
    @Id
    @SequenceGenerator(name = "product_store_sequence", allocationSize = 5, initialValue = 30000, sequenceName = "PRODUCT_STORE_SQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_store_sequence" )
    @Column(name="PRODUCT_ID")
    private Long productId;
    @ManyToOne
    @JoinColumn(name="CUSTOMER")
    private CustomerStore customerId;
    @Column(name="ACCOUNT_ID")
    private String accountId;
    @ManyToOne
    @JoinColumn(name="PRODUCT_TYPE")
    private ProductType productType;
    @ManyToOne
    @JoinColumn(name="BRANCH_TYPE")
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
