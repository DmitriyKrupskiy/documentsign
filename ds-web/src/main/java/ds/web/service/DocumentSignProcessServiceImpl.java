package ds.web.service;

import ds.dataservice.Company;
import ds.dataservice.Document;
import ds.dataservice.DocumentRepository;
import ds.dataservice.SignProcessState;
import ds.web.exception.DocumentIllegalStateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

public class DocumentSignProcessServiceImpl implements DocumentSignProcessService {

    @Autowired
    private DocumentRepository documentRepository;

    @Override
    @Transactional
    public void addDocument(Document document) throws DocumentIllegalStateException {
        if (documentRepository.getNumsByNameAndSigned(document.getName()) > 0) {
            throw new DocumentIllegalStateException("Document in process of signing. Delete operation not allowed");
        }
        documentRepository.save(document);
    }

    @Override
    @Transactional
    public void deleteDocument(long id, Company owner) throws DocumentIllegalStateException {
        Document document = documentRepository.getOne(id);
        if (document == null) {
            return;
        }
        if (SignProcessState.IN_PROCESS_STATES.contains(document.getDocumentSignProcessInfo().getSignProcessState())) {
            throw new DocumentIllegalStateException("Document in process of signing. Delete operation not allowed");
        } else if (document.getOwner() != owner) {
            throw new DocumentIllegalStateException("Only owner allow to delete document");
        } else {
            documentRepository.delete(document);
        }
    }

    @Override
    @Transactional
    public void signDocument(String name, Company company) {
        Document document = documentRepository.getDocumentByName(name);
        if (document == null) {
            return;
        }
        if (document.getOwner() == company) {
            if (SignProcessState.NOT_SIGNED == document.getDocumentSignProcessInfo().getSignProcessState()) {
                document.setLastUpdate(LocalDateTime.now())
                        .getDocumentSignProcessInfo()
                        .setSignProcessState(SignProcessState.SIGNED_BY_FIRST);

                documentRepository.save(document);
            }
        } else if (document.getReceiver() == company) {
            document.setLastUpdate(LocalDateTime.now())
                    .getDocumentSignProcessInfo()
                    .setSignProcessState(SignProcessState.SIGNED);
        }
    }

    @Override
    @Transactional
    public void changeDocument(Document document, Company changeAuthor) {
        if (document.getOwner() == changeAuthor) {
            document.setLastUpdate(LocalDateTime.now())
                    .setModified(true)
                    .getDocumentSignProcessInfo()
                    .setSignProcessState(SignProcessState.NOT_SIGNED);
            documentRepository.save(document);
        } else if (document.getReceiver() == changeAuthor) {
            Document documentNew = new Document(document.getReceiver(), document.getOwner())
                    .setLastUpdate(LocalDateTime.now())
                    .setName(document.getName());
            documentRepository.save(documentNew);
        }
    }
}
