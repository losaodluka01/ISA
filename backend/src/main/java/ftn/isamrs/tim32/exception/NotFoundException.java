package ftn.isamrs.tim32.exception;

public class NotFoundException extends RuntimeException {

    public NotFoundException() { }

    public NotFoundException(String message) {
        super(message);
    }
}