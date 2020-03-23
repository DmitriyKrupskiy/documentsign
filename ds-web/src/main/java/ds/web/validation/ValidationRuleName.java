package ds.web.validation;

public enum ValidationRuleName {
    ALLOWED_TIME_RULE("Валидатор времени работы системы"),
    MAX_DOCS_PARTICIPATION("Колчество документов максимальное");

    private String description;

    ValidationRuleName(String description) {
        this.description = description;
    }
}
