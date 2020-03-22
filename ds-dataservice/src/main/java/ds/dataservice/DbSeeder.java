package ds.dataservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DbSeeder implements CommandLineRunner {
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private DocumentRepository documentRepository;

    public DbSeeder(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        Company companySender = new Company().setName("ООО Цифра");
        Company companyReceiver = new Company().setName("ООО Буква");

        companyRepository.saveAll(List.of(companySender, companyReceiver));

        Document document1 = new Document(companySender, companyReceiver)
                .setName("Doc1.docx")
                .setDocumentSignProcessInfo(new DocumentSignProcessInfo().setSignProcessState(SignProcessState.NOT_SIGNED));
        Document document2 = new Document(companySender, companyReceiver)
                .setName("Doc2.docx")
                .setDocumentSignProcessInfo(new DocumentSignProcessInfo().setSignProcessState(SignProcessState.NOT_SIGNED));

        documentRepository.saveAll(List.of(document1, document2));
    }
}
