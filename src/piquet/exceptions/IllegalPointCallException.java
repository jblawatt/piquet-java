package piquet.exceptions;

public class IllegalPointCallException extends IllegalCallException {

    public IllegalPointCallException (String message, Integer number) {
        super(message, number);
    }

}