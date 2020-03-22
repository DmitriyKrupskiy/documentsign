package ds.dataservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {
    @Query("SELECT count(*) from document d where d.documentSignProcessInfo.signProcessState = 'SIGNED' " +
            "and d.name = ?1")
    int getNumsByNameAndSigned(String docName);

    @Query("SELECT FROM document d where d.name = ?1 ORDER BY lastUpdate desc LIMIT 1")
    Document getDocumentByName(String name);
}

