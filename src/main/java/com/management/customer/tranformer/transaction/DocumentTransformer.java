package com.management.customer.tranformer.transaction;

import com.management.customer.entity.transaction.RequestDocument;
import com.management.customer.entity.transaction.RequestProductRelationship;
import com.management.customer.model.transaction.request.DocumentModel;
import com.management.customer.model.transaction.request.ProductRelationshipModel;
import com.management.customer.tranformer.master.BranchTypeTransformer;
import com.management.customer.tranformer.master.DocumentTypeTransformer;
import com.management.customer.tranformer.master.ProductTypeTransformer;

public class DocumentTransformer {
    public static DocumentModel entityToModel(RequestDocument requestDocument){
        return new DocumentModel(requestDocument.getDocumentId(),
                DocumentTypeTransformer.entityToModel(requestDocument.getDocumentType()),
                requestDocument.getDocumentLinkPath(),
                requestDocument.getCreatedDate(),
                UserTransformer.entityToModel(requestDocument.getCreatedBy()));
    }
}
