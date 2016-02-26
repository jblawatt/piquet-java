package piquet.validators;

import piquet.ICart;
import piquet.exceptions.InvalidException;

/**
 * Created by jenko on 26.02.16.
 */
public interface IValidator {

    void validate (ICart[] carts) throws InvalidException;

}
