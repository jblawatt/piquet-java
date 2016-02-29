package piquet.validators;

import java.util.Arrays;
import java.util.List;

import piquet.ICart;
import piquet.exceptions.InvalidException;

import static piquet.Cart.*;

/**
 * Created by jenko on 29.02.16.
 */
public class SetValidator implements IValidator {

    public void validate(ICart[] carts) throws InvalidException {
        if (carts.length < 3) {
            throw new InvalidException();
        }

        List<Integer> validTypes = Arrays.asList(new Integer[] {TYPE_10, TYPE_JACK, TYPE_KING, TYPE_ACE});

        for (ICart cart: carts) {
            if (!validTypes.contains(cart.getType())) {
                throw new InvalidException();
            }
        }

    }

}
