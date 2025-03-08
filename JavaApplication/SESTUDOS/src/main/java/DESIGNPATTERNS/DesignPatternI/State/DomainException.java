package DESIGNPATTERNS.DesignPatternI.State;

public class DomainException extends RuntimeException{
    public DomainException() {
    }

    public DomainException(String message) {
        super(message);
    }
}
