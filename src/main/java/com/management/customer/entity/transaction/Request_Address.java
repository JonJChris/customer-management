package com.management.customer.entity.transaction;

import com.management.customer.entity.lookup.Country;
import com.management.customer.entity.lookup.RequestStage;
import com.management.customer.entity.lookup.RequestType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name="RQ_ADDRESS")
public class Request_Address {
    @Id
    @GeneratedValue
    @Column(name="ADDRESS_ID")
    private Long addressId;
    @Column(name="REQUEST_ID")
    private Request request;
    @Column(name="REGISTERED_ADDRESS_LINE1")
    private String registeredAddressLine1;
    @Column(name="REGISTERED_ADDRESS_LINE2")
    private String registeredAddressLine2;
    @Column(name="REGISTERED_ADDRESS_CITY")
    private String registeredAddressCity;
    @Column(name="REGISTERED_ADDRESS_STAGE")
    private String registeredAddressState;
    @Column(name="REGISTERED_ADDRESS_COUNTRY")
    private Country registeredAddressCountry;
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
    @Column(name="COMMUNICATION_ADDRESS_COUNTRY")
    private Country communicationAddressCountry;
    @Column(name="COMMUNICATION_ADDRESS_POSTAL_CODE")
    private String communicationAddressPostalCode;
    @Column(name="CREATED_DATE")
    private LocalDateTime createdOn;
    @Column(name="CREATED_BY")
    private User createdBy;
    @Column(name="LAST_UPDATED_DATE")
    private LocalDateTime updatedOn;
    @Column(name="LAST_UPDATED_BY")
    private User updatedBy;



}
