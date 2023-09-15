package com.management.customer.entity.transaction;

import com.management.customer.entity.authrisation.User;
import com.management.customer.entity.master.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name="RQ_CUSTOMER")
public class RequestCustomer {
    @Id
    @SequenceGenerator(name = "rq_customer_sequence", allocationSize = 5, initialValue = 2000, sequenceName = "RQ_CUSTOMER_SQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rq_customer_sequence" )
    @Column(name="ID")
    private Long id;
    @Column(name="CUSTOMER_ID")
    private Long customerId;
    @OneToOne
    @JoinColumn(name="REQUEST")
    private Request request;
    @ManyToOne
    @JoinColumn(name="TITLE_TYPE")
    private TitleType titleType;
    @Column(name="FIRST_NAME")
    private String firstname;
    @Column(name="LAST_NAME")
    private String lastName;
    @Column(name="DISPLAY_NAME")
    private String displayName;
    @ManyToOne
    @JoinColumn(name="NATIONALITY_TYPE")
    private CountryType nationality;
    @Column(name="EMAIL")
    private String email;
    @Column(name="DATE_OF_BIRTH")
    private LocalDate dateOfBirth;
    @ManyToOne
    @JoinColumn(name="MARITAL_STATUS_TYPE")
    private MaritalStatusType maritalStatusType;
    @ManyToOne
    @JoinColumn(name="CUSTOMER_TYPE")
    private CustomerType customerType;
    @ManyToOne
    @JoinColumn(name="EDUCATION_LEVEL_TYPE")
    private EducationLevelType educationLeveltype;
    @ManyToOne
    @JoinColumn(name="PROFESSION_TYPE")
    private ProfessionType professionType;
    @Column(name="ORGANISATION_NAME")
    private String organisationName;
    @ManyToOne
    @JoinColumn(name="YEARLY_INCOME_TYPE")
    private YearlyIncomeType yearlyIncome;
    @ManyToOne
    @JoinColumn(name="NOMINEE_RELATIONSHIP_TYPE")
    private RelationshipType nomineeRelationshipType;
    @Column(name="NOMINEE_FIRST_NAME")
    private String nomineeFirstName;
    @Column(name="NOMINEE_LAST_NAME")
    private String nomineeLastName;
    @Column(name="NOMINEE_DATE_OF_BIRTH")
    private LocalDate nomineeDateOfBirth;
    @ManyToOne
    @JoinColumn(name="HOME_OWNERSHIP_TYPE")
    private HomeOwnershipType homeOwnershipType;
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
