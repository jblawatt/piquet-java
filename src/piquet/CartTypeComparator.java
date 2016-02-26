package piquet;

import java.util.Comparator;

/**
 * Created by jenko on 26.02.16.
 */
public class CartTypeComparator implements Comparator<ICart> {

    public int compare(ICart o1, ICart o2) {
        if (o1.getType() == o2.getType()) {
            return 0;
        } else {
            if (o1.getType() < o2.getType()) {
                return -1;
            } else {
                return 0;
            }
        }
    }

}
