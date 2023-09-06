package com.management.customer.tranformer;

import com.management.customer.dto.CountryDTO;
import com.management.customer.dto.RequestTypeDTO;
import com.management.customer.entity.lookup.Country;
import com.management.customer.entity.lookup.RequestType;

public class CountryTransformer {
    public static CountryDTO entityToModel(Country country){
            return new CountryDTO(country.getId(), country.getCountryName());
        }

}
