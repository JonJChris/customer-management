package com.management.customer.entity.master;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "LOOKUP_EMPLOYMENT_STATUS_TYPE")
public class EmploymentStatusType {
    @Id
    @Column(name="ID")
    private Integer id;
    @Column(name="EMPLOYMENT_STATUS")
    private String employmentStatus;

}
