package Homework10;

public class DetailException extends Exception {

    public DetailException() {
        super();
    }

    public DetailException(String message) {
        super(message);
    }

    public DetailException(String message, Throwable cause) {
        super(message, cause);
    }

    public DetailException(Throwable cause) {
        super(cause);
    }
}