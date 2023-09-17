package com.management.customer.entity.authrisation;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="USER_TABLE")
public class User {
    public User(Integer id, String userName, String userFirstName, String userLastName){
        this.id = id;
        this.userName = userName;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
    }

    public User(Integer id, String userName, String userFirstName, String userLastName, String userEmail, String userCountry, String userPassword, boolean isActive, boolean isSystemUser){
        this.id = id;
        this.userName = userName;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userEmail = userEmail;
        this.userCountry = userCountry;
        this.userPassword = userPassword;
        this.isActive = isActive;
        this.isSystemUser = isSystemUser;
    }
    @Id
    @Column(name="ID")
    private Integer id;
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
    @Column(name="USER_PASSWORD")
    private String userPassword;
    @ManyToMany
    @JoinTable(name="USER_PERMISSION", joinColumns = @JoinColumn(name = "USER_ID"), inverseJoinColumns =  @JoinColumn(name="ROLE_TYPE_ID"))
    private List<UserRoleType> userRolesList;
    @Column(name="IS_ACTIVE")
    private Boolean isActive;
    @Column(name="IS_SYSTEM_USER")
    private Boolean isSystemUser;



}
