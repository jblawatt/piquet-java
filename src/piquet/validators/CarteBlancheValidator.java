package piquet.validators;

import piquet.ICart;
import piquet.exceptions.InvalidException;

import static piquet.Cart.TYPE_JACK;
import static piquet.Cart.TYPE_QUEEN;
import static piquet.Cart.TYPE_KING;

/**
 * Created by jenko on 29.02.16.
 */
public class CarteBlancheValidator implements IValidator {

    public void validate(ICart[] carts) throws InvalidException {
        for (ICart cart: carts) {
            int cartType = cart.getType();
            if (TYPE_JACK.equals(cartType) || TYPE_QUEEN.equals(cartType) || TYPE_KING.equals(cartType)) {
                throw new InvalidException();
            }
        }
    }

}
