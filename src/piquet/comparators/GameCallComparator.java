package piquet.comparators;

import piquet.ICart;

import java.util.Comparator;

/**
 * Created by jenko on 29.02.16.
 */
public class GameCallComparator implements Comparator<ICart> {

    public int compare(ICart o1, ICart o2) {
        if (o1.getColor() == o2.getColor()) {
            if (o1.getType() > o2.getType()) {
                return 1;
            } else {
                return -1;
            }
        } else {
            return -1;
        }
    }

}
