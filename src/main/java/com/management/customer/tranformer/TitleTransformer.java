package com.management.customer.tranformer;

import com.management.customer.entity.master.TitleType;
import com.management.customer.model.master.TitleModel;

public class TitleTransformer {
    public static TitleModel entityToModel(TitleType titleType){
            return new TitleModel(titleType.getId(), titleType.getTitle());
        }

}
