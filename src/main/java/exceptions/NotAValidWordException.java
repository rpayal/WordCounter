package exceptions;

public class NotAValidWordException extends Throwable {
    public NotAValidWordException(String message) {
        super(message);
    }
}
