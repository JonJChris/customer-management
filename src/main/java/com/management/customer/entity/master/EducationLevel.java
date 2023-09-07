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
@Table(name = "LOOKUP_EDUCATION_LEVEL")
public class EducationLevel {
    @Id
    @Column(name="ID")
    private Integer id;
    @Column(name="EDUCATION_LEVEL")
    private String educationLevel;

}
