package com.management.customer.entity.authrisation;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="USER_ROLE_TYPE")
public class UserRoleType {
    @Id
    @Column(name="ID")
    private Integer id;
    @Column(name="ROLE_TYPE_NAME")
    private String userRoleName;
}
