package com.management.customer.entity.store;

import com.management.customer.entity.authrisation.User;
import com.management.customer.entity.master.*;
import com.management.customer.entity.transaction.Request;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name="CUSTOMER_STORE")
public class CustomerStore {
    @Id
    @Column(name="CUSTOMER_ID")
    private Long customerId;
    @ManyToOne
    @JoinColumn(name="TITLE_ID")
    private TitleType titleType;
    @Column(name="FIRST_NAME")
    private String firstname;
    @Column(name="LAST_NAME")
    private String lastName;
    @Column(name="DISPLAY_NAME")
    private String displayName;
    @ManyToOne
    @JoinColumn(name="NATIONALITY")
    private CountryType nationality;
    @Column(name="EMAIL")
    private String email;
    @Column(name="DATE_OF_BIRTH")
    private LocalDateTime dateOfBirth;
    @ManyToOne
    @JoinColumn(name="MARITAL_STATUS_ID")
    private MaritalStatusType maritalStatusType;
    @ManyToOne
    @JoinColumn(name="CUSTOMER_TYPE_ID")
    private CustomerType customerType;
    @ManyToOne
    @JoinColumn(name="EDUCATION_LEVEL_ID")
    private EducationLevelType educationLeveltype;
    @ManyToOne
    @JoinColumn(name="PROFESSION_ID")
    private ProfessionType professionType;
    @Column(name="ORGANISATION_NAME")
    private String organisationName;
    @ManyToOne
    @JoinColumn(name="YEARLY_INCOME_ID")
    private YearlyIncomeType yearlyIncome;
    @ManyToOne
    @JoinColumn(name="NOMINEE_RELATIONSHIP_TYPE_ID")
    private RelationshipType nomineeRelationshipType;
    @Column(name="NOMINEE_FIRST_NAME")
    private String nomineeFirstName;
    @Column(name="NOMINEE_LAST_NAME")
    private String nomineeLastName;
    @Column(name="NOMINEE_DATE_OF_BIRTH")
    private LocalDateTime nomineeDateOfBirth;
    @ManyToOne
    @JoinColumn(name="HOME_OWNERSHIP_TYPE_ID")
    private HomeOwnershipType homeOwnershipType;
    @OneToOne(mappedBy = "customerId", fetch = FetchType.LAZY)
    private AddressStore addressStore;
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