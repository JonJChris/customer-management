package com.management.customer.tranformer.store;

import com.management.customer.entity.store.DocumentStore;
import com.management.customer.entity.transaction.RequestDocument;
import com.management.customer.model.store.DocumentStoreModel;
import com.management.customer.model.transaction.request.DocumentModel;
import com.management.customer.tranformer.master.DocumentTypeTransformer;
import com.management.customer.tranformer.transaction.UserTransformer;

public class DocumentStoreTransformer {
    public static DocumentStoreModel entityToModel(DocumentStore documentStore){
        return new DocumentStoreModel(documentStore.getDocumentId(),
                DocumentTypeTransformer.entityToModel(documentStore.getDocumentType()),
                documentStore.getDocumentLinkPath(),
                documentStore.getCreatedDate(),
                UserTransformer.entityToModel(documentStore.getCreatedBy()));
    }
}
