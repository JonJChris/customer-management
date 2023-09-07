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
@Table(name = "LOOKUP_STATUS")
public class Status {
    @Id
    @Column(name="ID")
    private Integer id;
    @Column(name="STATUS_CODE")
    private String statusCode;
    @Column(name="STATUS_NAME")
    private String statusName;
}
