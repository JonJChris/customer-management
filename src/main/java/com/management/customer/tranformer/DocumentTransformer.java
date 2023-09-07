package com.management.customer.tranformer;

import com.management.customer.model.master.DocumentTypeModel;
import com.management.customer.entity.master.DocumentType;

public class DocumentTransformer {
    public static DocumentTypeModel entityToModel(DocumentType documentType){
            return new DocumentTypeModel(documentType.getId(), documentType.getDocumentTypeName());
        }

}
