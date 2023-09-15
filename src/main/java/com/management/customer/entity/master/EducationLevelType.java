package com.management.customer.entity.master;

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
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "LOOKUP_EDUCATION_LEVEL_TYPE")
public class EducationLevelType {
    @Id
    @Column(name="ID")
    private Integer id;
    @Column(name="EDUCATION_LEVEL")
    private String educationLevel;

}
