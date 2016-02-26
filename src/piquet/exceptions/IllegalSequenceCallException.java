package piquet.exceptions;

/**
 * Created by jenko on 26.02.16.
 */
public class IllegalSequenceCallException extends IllegalCallException {

    protected Integer _number;

    public IllegalSequenceCallException(String message, Integer number) {
        super(message, number);
    }

}
