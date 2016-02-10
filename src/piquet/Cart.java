package piquet;

/**
 * Created by jenko on 09.02.16.
 */
public class Cart implements ICart {

    Integer _type;
    Integer _color;

    static final Integer TYPE_ACE = 14;
    static final Integer TYPE_KING = 13;
    static final Integer TYPE_QUEEN = 12;
    static final Integer TYPE_JACK = 11;
    static final Integer TYPE_10 = 10;
    static final Integer TYPE_9 = 9;
    static final Integer TYPE_8 = 8;
    static final Integer TYPE_7 = 7;

    static final Integer COLOR_CROSS = 4;
    static final Integer COLOR_SPADE = 3;
    static final Integer COLOR_HEART = 2;
    static final Integer COLOR_DIAMOND = 1;

    public Cart(Integer type, Integer color) {
        this._type = type;
        this._color = color;
    }

    @Override
    public String toString() {
        return Cart.class.toString() + ": type=" + this._type + ", color=" + this._color;
    }

}
