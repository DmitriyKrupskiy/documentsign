package ds.web.service;

import ds.dataservice.Company;
import ds.dataservice.Document;
import ds.web.exception.DocumentIllegalStateException;

public interface DocumentSignProcessService {
    void addDocument(Document document) throws DocumentIllegalStateException;
    void deleteDocument(long id, Company owner) throws DocumentIllegalStateException;
    void signDocument(String name, Company company);
    void changeDocument(Document document, Company changeAuthor);
}
