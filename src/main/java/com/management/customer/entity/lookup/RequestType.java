package com.management.customer.entity.lookup;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "LOOKUP_REQUEST_TYPE")
public class RequestType {
    @Id
    @Column(name="ID")
    private Integer id;
    @Column(name="REQUEST_TYPE")
    private String requestType;

}
