package piquet.comparators;

import piquet.ICart;

import java.util.Comparator;


public class SequenceCallComparator implements Comparator<ICart[]> {

    @Override
    public int compare(ICart[] o1, ICart[] o2) {
        if (o1 == null && o2 == null) {
            return 0;
        } else {
            if (o1 == null && o2 != null) {
                return -1;
            }
            if (o1 != null && o2 == null) {
                return 1;
            }
        }
        if (o1.length == o2.length) {
            Integer o1Type = o1[o1.length - 1].getType();
            Integer o2Type = o2[o2.length - 1].getType();
            if (o1Type == o2Type) {
                return 0;
            } else {
                if (o1Type > o2Type) {
                    return 1;
                } else {
                    return -1;
                }
            }
        } else {
            if (o1.length > o2.length) {
                return 1;
            } else {
                return -1;
            }
        }
    }
}
