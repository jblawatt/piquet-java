package piquet.comparators;

import piquet.ICart;

import java.util.Comparator;

/**
 * Created by jenko on 29.02.16.
 */
public class SetComparator implements Comparator<ICart[]> {

    protected int getHighestCart(ICart[] carts) {
        int highest = carts[0].getType();
        for (int i = 1; i < carts.length; i++) {
            if (carts[i].getType() > highest) {
                highest = carts[i].getType();
            }
        }
        return highest;
    }

    public int compare(ICart[] o1, ICart[] o2) {

        if (o1 == null && o2 == null) {
            return 0;
        } else {
            if (o1 != null && o2 == null) {
                return 1;
            }
            if (o1 == null && o2 != null) {
                return -1;
            }
        }

        if (o1.length > o2.length) {
            return 1;
        } else {
            if (o1.length < o2.length) {
                return -1;
            } else {
                int first = this.getHighestCart(o1);
                int second = this.getHighestCart(o2);
                if (first > second) {
                    return 1;
                } else {
                    if (first < second) {
                        return -1;
                    } else {
                        return 0;
                    }
                }
            }
        }


    }

}
