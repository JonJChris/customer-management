package com.management.customer.tranformer;

import com.management.customer.model.master.CountryModel;
import com.management.customer.entity.master.Country;

public class CountryTransformer {
    public static CountryModel entityToModel(Country country){
            return new CountryModel(country.getId(), country.getCountryName());
        }

}
