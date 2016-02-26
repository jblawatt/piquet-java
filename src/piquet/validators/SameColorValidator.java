package piquet.validators;

import piquet.ICart;
import piquet.exceptions.InvalidException;

/**
 * Created by jenko on 26.02.16.
 */
public class SameColorValidator implements IValidator {

    public void validate(ICart[] carts) throws InvalidException {
        Integer currentColor = null;
        // prüfen ob die karten von gleichen typ sind.
        currentColor = carts[0].getColor();
        for (int i = 1; i < carts.length; i++) {
            if (currentColor != carts[i].getColor()) {
                throw new InvalidException();
            }
        }
    }

}
