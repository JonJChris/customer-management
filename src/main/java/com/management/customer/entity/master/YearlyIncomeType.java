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
@Table(name = "LOOKUP_YEARLY_INCOME_TYPE")
public class YearlyIncomeType {
    @Id
    @Column(name="ID")
    private Integer id;
    @Column(name="YEARLY_INCOME")
    private String yearlyIncome;

}