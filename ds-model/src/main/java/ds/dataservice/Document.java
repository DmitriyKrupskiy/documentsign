package ds.dataservice;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String name;
    final private Company owner;
    final private Company receiver;
    private DocumentSignProcessInfo documentSignProcessInfo = new DocumentSignProcessInfo().setSignProcessState(SignProcessState.NOT_SIGNED);
    private LocalDateTime lastUpdate;
    private boolean isModified;

    public Document(Company owner, Company receiver) {
        this.owner = owner;
        this.receiver = receiver;
    }

    public long getId() {
        return id;
    }

    public Document setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Document setName(String name) {
        this.name = name;
        return this;
    }

    @ManyToOne
    public Company getOwner() {
        return owner;
    }

    @ManyToOne
    public Company getReceiver() {
        return receiver;
    }

    @OneToOne(mappedBy = "document", cascade = CascadeType.ALL)
    public DocumentSignProcessInfo getDocumentSignProcessInfo() {
        return documentSignProcessInfo;
    }

    public Document setDocumentSignProcessInfo(DocumentSignProcessInfo documentSignProcessInfo) {
        this.documentSignProcessInfo = documentSignProcessInfo;
        return this;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public Document setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
        return this;
    }

    public boolean isModified() {
        return isModified;
    }

    public Document setModified(boolean isModified) {
        this.isModified = isModified;
        return this;
    }
}
