package piquet.exceptions;

/**
 * Created by jenko on 26.02.16.
 */
public class IllegalCallException extends Exception {

    protected Integer _number;

    public IllegalCallException(String message, Integer number) {
        super(message);
        this._number = number;
    }


}
