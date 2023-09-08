package com.management.customer.tranformer;

import com.management.customer.entity.master.CountryType;
import com.management.customer.model.master.CountryModel;

public class CountryTransformer {
    public static CountryModel entityToModel(CountryType countryType){
            return new CountryModel(countryType.getId(), countryType.getCountryName());
        }

}
