package com.management.customer.tranformer;

import com.management.customer.model.master.ProfessionModel;
import com.management.customer.entity.master.Profession;

public class ProfessionTransformer {
    public static ProfessionModel entityToModel(Profession profession){
            return new ProfessionModel(profession.getId(), profession.getProfession());
        }

}
