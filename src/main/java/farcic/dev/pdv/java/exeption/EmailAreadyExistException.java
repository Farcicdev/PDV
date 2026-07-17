package farcic.dev.pdv.java.exeption;

public class EmailAreadyExistException extends RuntimeException {
    public EmailAreadyExistException(String message) {
        super(message);
    }
}
