package piquet.validators;

import piquet.ICart;
import piquet.exceptions.InvalidException;
import piquet.exceptions.InvalidFollowupException;

/**
 * Created by jenko on 26.02.16.
 */
public class FollowingTypeValidator implements IValidator {

    public void validate(ICart[] carts) throws InvalidFollowupException {
        Integer currentType = null;
        // folgen prüfen
        for (ICart cart: carts) {
            if (currentType == null) {
                currentType = cart.getType();
            } else {
                if (currentType + 1 == cart.getType()) {
                    currentType = cart.getType();
                } else {
                    throw new InvalidFollowupException(currentType, cart.getType());
                }
            }
        }
    }

}
