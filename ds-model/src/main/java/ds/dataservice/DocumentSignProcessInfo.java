package ds.dataservice;

import javax.persistence.*;

@Entity
public class DocumentSignProcessInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private SignProcessState signProcessState;
    private Document document;

    public long getId() {
        return id;
    }

    public DocumentSignProcessInfo setId(long id) {
        this.id = id;
        return this;
    }

    @Enumerated(EnumType.STRING)
    public SignProcessState getSignProcessState() {
        return signProcessState;
    }

    public DocumentSignProcessInfo setSignProcessState(SignProcessState signProcessState) {
        this.signProcessState = signProcessState;
        return this;
    }

    public Document getDocument() {
        return document;
    }

    @OneToOne
    @MapsId
    public DocumentSignProcessInfo setDocument(Document document) {
        this.document = document;
        return this;
    }
}
