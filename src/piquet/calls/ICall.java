package piquet.calls;

import piquet.ICart;
import piquet.IPointable;
import piquet.exceptions.IllegalCallException;

/**
 * Created by jenko on 26.02.16.
 */
public interface ICall extends IPointable {

    void answer(ICart[] carts) throws IllegalCallException;
    Boolean wasAnswered();

}
