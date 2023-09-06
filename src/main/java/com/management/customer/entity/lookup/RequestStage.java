package com.management.customer.entity.lookup;

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
@Table(name = "LOOKUP_REQUEST_STAGE")
public class RequestStage {
    @Id
    @Column(name="ID")
    private Integer id;
    @Column(name="REQUEST_STAGE")
    private String requestStage;

}
