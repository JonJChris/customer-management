package com.management.customer.entity.transaction;

import com.management.customer.entity.authrisation.User;
import com.management.customer.entity.master.BranchType;
import com.management.customer.entity.master.DocumentType;
import com.management.customer.entity.master.ProductType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name="RQ_DOCUMENT")
public class RequestDocument {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Long Id;
    @Column(name="DOCUMENT_ID")
    private Long documentId;
    @ManyToOne
    @JoinColumn(name="REQUEST")
    private Request request;
    @ManyToOne
    @JoinColumn(name="DOCUMENT_TYPE")
    private DocumentType documentType;
    @Column(name="DOCUMENT_LINK_PATH")
    private String documentLinkPath;
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
