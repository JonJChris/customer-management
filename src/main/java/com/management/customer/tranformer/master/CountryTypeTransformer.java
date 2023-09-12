package com.management.customer.tranformer.master;

import com.management.customer.entity.master.CountryType;
import com.management.customer.model.master.CountryModel;

public class CountryTypeTransformer {
    public static CountryModel entityToModel(CountryType countryType){
            return new CountryModel(countryType.getId(), countryType.getCountryName());
        }

}
