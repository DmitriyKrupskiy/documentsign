package ds.web.validation;

public enum ValidationMessage {
    NO_WARNING("Нет ограничений"),
    TIME_NOT_ALLOWED_TO_PROCEED("В данное время изменять/подписывать документ запрещено");

    private String description;

    ValidationMessage(String description) {
        this.description = description;
    }
}
