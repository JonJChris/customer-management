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
@Table(name = "LOOKUP_COUNTRY")
public class Country {
    @Id
    @Column(name="ID")
    private Integer id;
    @Column(name="COUNTRY_NAME_CAPS")
    private String countryNameCaps;
    @Column(name="COUNTRY_NAME")
    private String countryName;
    @Column(name="ISO2")
    private String iso2;
    @Column(name="ISO3")
    private String iso3;
    @Column(name="COUNTRY_CODE")
    private String countryCode;
    @Column(name="PHONE_CODE")
    private String phoneCode;

}
