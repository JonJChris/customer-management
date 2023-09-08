package com.management.customer.tranformer;

import com.management.customer.model.master.ProfessionModel;
import com.management.customer.entity.master.ProfessionType;

public class ProfessionTransformer {
    public static ProfessionModel entityToModel(ProfessionType professionType){
            return new ProfessionModel(professionType.getId(), professionType.getProfession());
        }

}
