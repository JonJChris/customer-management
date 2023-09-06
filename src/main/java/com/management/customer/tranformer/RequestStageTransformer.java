package com.management.customer.tranformer;

import com.management.customer.dto.ProfessionDTO;
import com.management.customer.dto.RequestStageDTO;
import com.management.customer.entity.lookup.Profession;
import com.management.customer.entity.lookup.RequestStage;

public class RequestStageTransformer {
    public static RequestStageDTO entityToModel(RequestStage requestStage){
            return new RequestStageDTO(requestStage.getId(), requestStage.getRequestStage());
        }

}
