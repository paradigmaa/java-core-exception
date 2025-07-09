package school.sorokin.javacore.exception.custom_exception;

public class BookNotFoundException extends RuntimeException{
    public BookNotFoundException(String message) {
        super(message);
    }
}
