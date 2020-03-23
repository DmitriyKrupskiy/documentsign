package ds.web.validation;

public interface ValidationRule<T> {

    ValidationMessage validate(T object);

    public ValidationRuleName getName();
}
