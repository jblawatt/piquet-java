package piquet;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jenko on 09.02.16.
 */
public class Cart implements ICart {

    Integer _type;
    Integer _color;

    public static final Integer TYPE_ACE = 14;
    public static final Integer TYPE_KING = 13;
    public static final Integer TYPE_QUEEN = 12;
    public static final Integer TYPE_JACK = 11;
    public static final Integer TYPE_10 = 10;
    public static final Integer TYPE_9 = 9;
    public static final Integer TYPE_8 = 8;
    public static final Integer TYPE_7 = 7;

    public static final Integer COLOR_CROSS = 4;
    public static final Integer COLOR_SPADE = 3;
    public static final Integer COLOR_HEART = 2;
    public static final Integer COLOR_DIAMOND = 1;

    public static final Map<Integer, String> COLOR_MAP;
    static {
        Map<Integer, String> m = new HashMap<Integer, String>();
        m.put(COLOR_CROSS, "COLOR_CROSS");
        m.put(COLOR_SPADE, "COLOR_SPADE");
        m.put(COLOR_HEART, "COLOR_HEART");
        m.put(COLOR_DIAMOND, "COLOR_DIAMOND");
        COLOR_MAP = Collections.unmodifiableMap(m);
    }

    public static final Map<Integer, String> TYPE_MAP;
    static {
        Map<Integer, String> m = new HashMap<Integer, String>();
        m.put(TYPE_ACE, "TYPE_ACE");
        m.put(TYPE_KING, "TYPE_KING");
        m.put(TYPE_QUEEN, "TYPE_QUEEN");
        m.put(TYPE_JACK, "TYPE_JACK");
        m.put(TYPE_10, "TYPE_10");
        m.put(TYPE_9, "TYPE_9");
        m.put(TYPE_8, "TYPE_8");
        m.put(TYPE_7, "TYPE_7");
        TYPE_MAP = Collections.unmodifiableMap(m);
    }

    public Cart(Integer type, Integer color) {
        this._type = type;
        this._color = color;
    }

    public Integer getType() {
        return this._type;
    }

    public Integer getColor() {
        return this._color;
    }

    @Override
    public String toString() {
        return Cart.class.toString() + ": type=" + this._type + ", color=" + this._color;
    }

}
