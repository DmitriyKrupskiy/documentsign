package ds.web.validation.rules;

import ds.dataservice.Company;
import ds.dataservice.ConfigurationRepository;
import ds.dataservice.DocumentRepository;
import ds.web.validation.ValidationMessage;
import ds.web.validation.ValidationRule;
import ds.web.validation.ValidationRuleName;
import org.springframework.beans.factory.annotation.Autowired;

import static ds.dataservice.ConfigurationTypes.MAX_DOCS_PARTIC;
import static ds.web.validation.ValidationRuleName.MAX_DOCS_PARTICIPATION;


public class ValidationMaxDocumentRule implements ValidationRule<Company> {
    @Autowired
    private DocumentRepository documentRepository;
    @Autowired
    private ConfigurationRepository configurationRepository;

    @Override
    public ValidationMessage validate(Company company) {
        int maxCompanies = Integer.parseInt(configurationRepository.getConfigurationByName(MAX_DOCS_PARTIC.getName()));
        if (documentRepository.getNumByCompanyParticipation(company.getId()) > maxCompanies) {
            return ValidationMessage.PARTICIPATION_LIMIT_EXCEEDED;
        }
        return ValidationMessage.NO_WARNING;
    }

    @Override
    public ValidationRuleName getName() {
        return MAX_DOCS_PARTICIPATION;
    }
}
