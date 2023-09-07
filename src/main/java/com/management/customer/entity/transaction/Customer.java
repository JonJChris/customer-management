package com.management.customer.entity.transaction;

import com.management.customer.entity.authrisation.User;
import com.management.customer.entity.master.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name="RQ_CUSTOMER")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Long id;
    @Column(name="CUSTOMER_ID")
    private Long customerId;
    @OneToOne
    @JoinColumn(name="REQUEST_ID")
    private Request request;
    @ManyToOne
    @JoinColumn(name="TITLE_ID")
    private Title title;
    @Column(name="FIRST_NAME")
    private String firstname;
    @Column(name="LAST_NAME")
    private String lastName;
    @Column(name="DISPLAY_NAME")
    private String displayName;
    @ManyToOne
    @JoinColumn(name="NATIONALITY")
    private Country nationality;
    @Column(name="EMAIL")
    private String email;
    @Column(name="DATE_OF_BIRTH")
    private LocalDateTime dateOfBirth;
    @ManyToOne
    @JoinColumn(name="MARITAL_STATUS_ID")
    private MaritalStatus maritalStatus;
    @ManyToOne
    @JoinColumn(name="CUSTOMER_TYPE_ID")
    private CustomerType customerType;
    @ManyToOne
    @JoinColumn(name="EDUCATION_LEVEL_ID")
    private EducationLevel educationLevel;
    @ManyToOne
    @JoinColumn(name="PROFESSION_ID")
    private Profession profession;
    @Column(name="ORGANISATION_NAME")
    private String organisationName;
    @ManyToOne
    @JoinColumn(name="YEARLY_INCOME_ID")
    private YearlyIncome yearlyIncome;
    @ManyToOne
    @JoinColumn(name="NOMINEE_RELATIONSHIP_TYPE_ID")
    private RelationshipType nomineeRelationshipType;
    @Column(name="NOMINEE_FIRST_NAME")
    private String nomineeFirstName;
    @Column(name="NOMINEE_LAST_NAME")
    private String nomineeLastName;
    @Column(name="NOMINEE_DATE_OF_BIRTH")
    private String nomineeDateOfBirth;
    @ManyToOne
    @JoinColumn(name="HOME_OWNERSHIP_TYPE_ID")
    private HomeOwnershipType homeOwnershipType;
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
