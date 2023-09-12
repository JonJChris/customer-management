package com.management.customer.tranformer.master;

import com.management.customer.model.master.DocumentTypeModel;
import com.management.customer.entity.master.DocumentType;

public class DocumentTypeTransformer {
    public static DocumentTypeModel entityToModel(DocumentType documentType){
            return new DocumentTypeModel(documentType.getId(), documentType.getDocumentTypeName());
        }

}
