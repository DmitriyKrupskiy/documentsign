package ds.web.exception;

public class CompanyLimitExceededException extends Exception {
    public CompanyLimitExceededException() {
        super("Превышен лимит участия компании в документообороте");
    }
}
