package com.management.customer.tranformer.master;

import com.management.customer.entity.master.TitleType;
import com.management.customer.model.master.TitleModel;

public class TitleTypeTransformer {
    public static TitleModel entityToModel(TitleType titleType){
            return new TitleModel(titleType.getId(), titleType.getTitle());
        }

}
