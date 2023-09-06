package com.management.customer.entity.transaction;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="APPLICATION_USER")
public class User {
    @Id
    @Column(name="ID")
    private Integer Id;
    @Column(name="USER_NAME")
    private String userName;
    @Column(name="FIRST_NAME")
    private String userFirstName;
    @Column(name="LAST_NAME")
    private String userLastName;
    @Column(name="EMAIL")
    private String userEmail;
    @Column(name="COUNTRY")
    private String userCountry;
    @Column(name="PASSWORD")
    private String userPassword;
    @Column(name="IS_ACTIVE")
    private Boolean isActive;
    @Column(name="IS_SYSTEM_USER")
    private Boolean isSystemUser;



}
