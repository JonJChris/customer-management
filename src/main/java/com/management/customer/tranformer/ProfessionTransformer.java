package com.management.customer.tranformer;

import com.management.customer.dto.MaritalStatusDTO;
import com.management.customer.dto.ProfessionDTO;
import com.management.customer.entity.lookup.MaritalStatus;
import com.management.customer.entity.lookup.Profession;

public class ProfessionTransformer {
    public static ProfessionDTO entityToModel(Profession profession){
            return new ProfessionDTO(profession.getId(), profession.getProfession());
        }

}
