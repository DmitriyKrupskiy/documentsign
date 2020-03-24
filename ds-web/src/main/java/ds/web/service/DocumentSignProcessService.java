package ds.web.service;

import ds.dataservice.Company;
import ds.dataservice.Document;
import ds.web.exception.CompanyLimitExceededException;
import ds.web.exception.DocumentIllegalStateException;

public interface DocumentSignProcessService {

    void addDocument(Document document) throws DocumentIllegalStateException, CompanyLimitExceededException;

    void deleteDocument(long id, Company owner) throws DocumentIllegalStateException;

    void signDocument(String name, Company company) throws DocumentIllegalStateException;

    void changeDocument(Document document, Company changeAuthor);
}
