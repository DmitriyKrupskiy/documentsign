package ds.web.validation.rules;

import ds.dataservice.ConfigurationRepository;
import ds.dataservice.Document;
import ds.web.validation.ValidationMessage;
import ds.web.validation.ValidationRule;
import ds.web.validation.ValidationRuleName;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static ds.dataservice.ConfigurationTypes.ALLOWED_TIME_CONFIG;
import static ds.web.validation.ValidationMessage.NO_WARNING;
import static ds.web.validation.ValidationMessage.TIME_NOT_ALLOWED_TO_PROCEED;

public class ValidationTimeRule implements ValidationRule<Document> {
    @Autowired
    private ConfigurationRepository configurationRepository;

    @Override
    public ValidationMessage validate(Document document) {
        List<String> hours = Arrays.stream(configurationRepository.getConfigurationByName(ALLOWED_TIME_CONFIG.getName()).split(";")).collect(Collectors.toList());
        LocalTime now = LocalTime.now();
        if (LocalTime.of(Integer.parseInt(hours.get(0)), 0,0).compareTo(now) > 0
                && now.compareTo(LocalTime.of(Integer.parseInt(hours.get(1)), 0,0)) > 0) {
            return NO_WARNING;
        }
        return TIME_NOT_ALLOWED_TO_PROCEED;
    }

    @Override
    public ValidationRuleName getName() {
        return ValidationRuleName.ALLOWED_TIME_RULE;
    }
}
