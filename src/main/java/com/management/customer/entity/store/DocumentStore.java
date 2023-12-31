package com.management.customer.entity.store;

import com.management.customer.entity.authrisation.User;
import com.management.customer.entity.master.DocumentType;
import com.management.customer.entity.transaction.Request;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name="DOCUMENT_STORE")
public class DocumentStore {
    @Id
    @SequenceGenerator(name = "document_store_sequence", allocationSize = 5, initialValue = 40000, sequenceName = "DOCUMENT_STORE_SQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "document_store_sequence" )
    @Column(name="DOCUMENT_ID")
    private Long documentId;
    @ManyToOne
    @JoinColumn(name="CUSTOMER")
    private CustomerStore customerId;
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
