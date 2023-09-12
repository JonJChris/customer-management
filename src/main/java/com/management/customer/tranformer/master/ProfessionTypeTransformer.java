package com.management.customer.tranformer.master;

import com.management.customer.model.master.ProfessionModel;
import com.management.customer.entity.master.ProfessionType;

public class ProfessionTypeTransformer {
    public static ProfessionModel entityToModel(ProfessionType professionType){
            return new ProfessionModel(professionType.getId(), professionType.getProfession());
        }

}
