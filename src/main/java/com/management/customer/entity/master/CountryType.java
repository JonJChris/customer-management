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
@Table(name = "LOOKUP_COUNTRY_TYPE")
public class CountryType {
    public CountryType(Integer id, String countryName){
        this.id = id;
        this.countryName = countryName;
    }
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
