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
    @Column(name="DOCUMENT_ID")
    private Long documentId;
    @OneToOne
    @JoinColumn(name="CUSTOMER_ID")
    private CustomerStore customerId;
    @ManyToOne
    @JoinColumn(name="DOCUMENT_TYPE_ID")
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
