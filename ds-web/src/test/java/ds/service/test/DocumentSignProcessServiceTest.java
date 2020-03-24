package ds.service.test;

import ds.dataservice.Company;
import ds.dataservice.ConfigurationRepository;
import ds.dataservice.Document;
import ds.dataservice.DocumentRepository;
import ds.web.service.DocumentSignProcessService;
import ds.web.service.DocumentSignProcessServiceImpl;
import ds.web.validation.ValidationRuleMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class DocumentSignProcessServiceTest {
    @Mock
    private DocumentRepository documentRepository;
    @Mock
    private ConfigurationRepository configurationRepository;
    @InjectMocks
    private DocumentSignProcessServiceImpl documentSignProcessService;

    @Autowired
    private ValidationRuleMapper validationRuleMap;

    private Company owner;
    private Company receiver;

    @Before
    public void before() {
        owner = new Company();
        receiver = new Company();
    }

    @Test
    public void testAddDocumentSaved() {
        Document document = new Document(owner, receiver)
                .setId(1L)
                .setName("Doc.1.xls")
                .setLastUpdate(LocalDateTime.now());

        when(documentRepository.getNumByCompanyParticipation(any())).thenReturn(10);
        when(documentRepository.getNumsSignedDocsByName(any())).thenReturn(0);
        when(documentRepository.save(any())).thenReturn(document);


        try {
            documentSignProcessService.addDocument(document);
        } catch (Exception ex) {
            //ignored
        }

        verify(documentRepository).save(any());
    }

}
