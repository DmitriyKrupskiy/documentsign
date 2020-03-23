package ds.web.validation;

public enum ValidationMessage {
    NO_WARNING("Нет ограничений"),
    TIME_NOT_ALLOWED_TO_PROCEED("В данное время изменять/подписывать документ запрещено"),
    PARTICIPATION_LIMIT_EXCEEDED("Лимит по участию в подписании документов превышен");

    private String description;

    ValidationMessage(String description) {
        this.description = description;
    }
}
