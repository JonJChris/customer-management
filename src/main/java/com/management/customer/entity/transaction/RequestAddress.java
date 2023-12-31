package com.management.customer.entity.transaction;

import com.management.customer.entity.authrisation.User;
import com.management.customer.entity.master.CountryType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name="RQ_ADDRESS")
public class RequestAddress {
    @Id
    @SequenceGenerator(name = "rq_address_sequence", allocationSize = 5, initialValue = 3000, sequenceName = "RQ_ADDRESS_SQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rq_address_sequence" )
    @Column(name="ID")
    private Long Id;
    @Column(name="ADDRESS_ID")
    private Long addressId;
    @OneToOne
    @JoinColumn(name="REQUEST")
    private Request request;
    @Column(name="REGISTERED_ADDRESS_LINE1")
    private String registeredAddressLine1;
    @Column(name="REGISTERED_ADDRESS_LINE2")
    private String registeredAddressLine2;
    @Column(name="REGISTERED_ADDRESS_CITY")
    private String registeredAddressCity;
    @Column(name="REGISTERED_ADDRESS_STATE")
    private String registeredAddressState;
    @ManyToOne
    @JoinColumn(name="REGISTERED_ADDRESS_COUNTRY_TYPE")
    private CountryType registeredAddressCountryType;
    @Column(name="REGISTERED_ADDRESS_POSTAL_CODE")
    private String registeredAddressPostalCode;
    @Column(name="COMMUNICATION_ADDRESS_LINE1")
    private String communicationAddressLine1;
    @Column(name="COMMUNICATION_ADDRESS_LINE2")
    private String communicationAddressLine2;
    @Column(name="COMMUNICATION_ADDRESS_CITY")
    private String communicationAddressCity;
    @Column(name="COMMUNICATION_ADDRESS_STATE")
    private String communicationAddressState;
    @ManyToOne
    @JoinColumn(name="COMMUNICATION_ADDRESS_COUNTRY_TYPE")
    private CountryType communicationAddressCountryType;
    @Column(name="COMMUNICATION_ADDRESS_POSTAL_CODE")
    private String communicationAddressPostalCode;
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
