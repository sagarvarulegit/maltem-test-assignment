package support.exceptions;

public class TestDataNotFoundException extends RuntimeException {
    public TestDataNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
