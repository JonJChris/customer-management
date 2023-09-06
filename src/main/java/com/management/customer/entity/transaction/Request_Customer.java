package com.management.customer.entity.transaction;

import com.management.customer.entity.lookup.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name="RQ_REQUEST_CUSTOMER")
public class Request_Customer {

    @Id
    @GeneratedValue
    @Column(name="ID")
    private Long id;
    @Column(name="TITLE_ID")
    private Title title;
    @Column(name="FIRST_NAME")
    private String firstname;
    @Column(name="LAST_NAME")
    private String lastName;
    @Column(name="DISPLAY_NAME")
    private String displayName;
    @Column(name="NATIONALITY")
    private Country nationality;
    @Column(name="EMAIL")
    private String email;
    @Column(name="DATE_OF_BIRTH")
    private LocalDateTime dateOfBirth;
    @Column(name="MARITAL_STATUS_ID")
    private MaritalStatus maritalStatus;
    @Column(name="CUSTOMER_TYPE_ID")
    private CustomerType customerType;
    @Column(name="EDUCATION_LEVEL_ID")
    private EducationLevel educationLevel;
    @Column(name="PROFESSION_ID")
    private Profession profession;
    @Column(name="ORGANISATION_NAME")
    private String organisationName;
    @Column(name="YEARLY_INCOME_ID")
    private YearlyIncome yearlyIncome;
    @Column(name="NOMINEE_RELATIONSHIP_TYPE_ID")
    private RelationshipType nomineeRelationshipType;
    @Column(name="NOMINEE_FIRST_NAME")
    private String nomineeFirstName;
    @Column(name="NOMINEE_LAST_NAME")
    private String nomineeLastName;
    @Column(name="NOMINEE_DATE_OF_BIRTH")
    private String nomineeDateOfBirth;
    @Column(name="HOME_OWNERSHIP_TYPE_ID")
    private HomeOwnershipType homeOwnershipType;
    @Column(name="CREATED_DATE")
    private LocalDateTime createdOn;
    @Column(name="CREATED_BY")
    private User createdBy;
    @Column(name="LAST_UPDATED_DATE")
    private LocalDateTime updatedOn;
    @Column(name="LAST_UPDATED_BY")
    private User updatedBy;



}
