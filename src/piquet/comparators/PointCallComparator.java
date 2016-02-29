package piquet.comparators;

import piquet.ICart;

import java.util.Comparator;

/**
 * Created by jenko on 29.02.16.
 */
public class PointCallComparator implements Comparator<ICart[]> {

    protected Integer getSum(ICart[] carts) {
        int value = 0;
        for (ICart cart: carts) {
            value += cart.getType();
        }
        return value;
    }

    public int compare(ICart[] o1, ICart[] o2) {

        if (o1 == null && o2 == null) {
            return 0;
        } else {
            if (o1 == null && o2 != null) {
                return -1;
            } else {
                if (o1 != null && o2 == null) {
                    return 1;
                }
            }
        }

        if (o1.length == o2.length) {
            int value = this.getSum(o1) - this.getSum(o2);
            if (value > 0) {
                return 1;
            } else {
                if (value < 0) {
                    return -1;
                } else {
                    return value;
                }
            }
        } else {
            int value = o1.length - o2.length;
            if (value > 0) {
                return 1;
            } else {
                return -1;
            }
        }

    }

}
