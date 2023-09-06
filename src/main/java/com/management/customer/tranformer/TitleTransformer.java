package com.management.customer.tranformer;

import com.management.customer.dto.RequestTypeDTO;
import com.management.customer.dto.TitleDTO;
import com.management.customer.entity.lookup.RequestType;
import com.management.customer.entity.lookup.Title;

public class TitleTransformer {
    public static TitleDTO entityToModel(Title title){
            return new TitleDTO(title.getId(), title.getTitle());
        }

}
