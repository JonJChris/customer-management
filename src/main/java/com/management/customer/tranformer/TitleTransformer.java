package com.management.customer.tranformer;

import com.management.customer.model.master.TitleModel;
import com.management.customer.entity.master.Title;

public class TitleTransformer {
    public static TitleModel entityToModel(Title title){
            return new TitleModel(title.getId(), title.getTitle());
        }

}
