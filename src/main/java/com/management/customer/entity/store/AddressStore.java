package com.management.customer.entity.store;

import com.management.customer.entity.authrisation.User;
import com.management.customer.entity.master.CountryType;
import com.management.customer.entity.transaction.Request;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name="ADDRESS_STORE")
public class AddressStore {
    @Id
    @Column(name="ADDRESS_ID")
    @SequenceGenerator(name = "address_store_sequence", allocationSize = 5, initialValue = 20000, sequenceName = "ADDRESS_STORE_SQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_store_sequence" )
    private Long addressId;
    @OneToOne
    @JoinColumn(name="CUSTOMER")
    private CustomerStore customerId;
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
