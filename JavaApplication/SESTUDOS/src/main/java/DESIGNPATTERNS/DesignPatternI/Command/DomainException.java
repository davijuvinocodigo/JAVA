package DESIGNPATTERNS.DesignPatternI.Command;

public class DomainException extends RuntimeException{
    public DomainException() {
    }

    public DomainException(String message) {
        super(message);
    }
}
