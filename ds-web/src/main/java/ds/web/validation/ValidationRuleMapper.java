package ds.web.validation;

import ds.web.validation.rules.ValidationMaxDocumentRule;
import ds.web.validation.rules.ValidationTimeRule;
import org.springframework.stereotype.Service;
import java.util.Map;

import static ds.web.validation.ValidationRuleName.ALLOWED_TIME_RULE;
import static ds.web.validation.ValidationRuleName.MAX_DOCS_PARTICIPATION;


@Service
public class ValidationRuleMapper {
    private Map<ValidationRuleName, ValidationRule> validationRuleMap;


    public ValidationRuleMapper() {
        validationRuleMap.put(ALLOWED_TIME_RULE, new ValidationTimeRule());

        validationRuleMap.put(MAX_DOCS_PARTICIPATION, new ValidationMaxDocumentRule());
    }

    public ValidationRule getValidationRule(ValidationRuleName name) {
        return validationRuleMap.get(name);
    }
}
