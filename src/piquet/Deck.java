package piquet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static piquet.Cart.*;

public class Deck implements IDeck {

    List<Cart> _carts;

    public Deck() {
        this._carts = new ArrayList<Cart>();
        this._carts.add(new Cart(TYPE_ACE, COLOR_CROSS));
        this._carts.add(new Cart(TYPE_KING, COLOR_CROSS));
        this._carts.add(new Cart(TYPE_QUEEN, COLOR_CROSS));
        this._carts.add(new Cart(TYPE_JACK, COLOR_CROSS));
        this._carts.add(new Cart(TYPE_10, COLOR_CROSS));
        this._carts.add(new Cart(TYPE_9, COLOR_CROSS));
        this._carts.add(new Cart(TYPE_8, COLOR_CROSS));
        this._carts.add(new Cart(TYPE_7, COLOR_CROSS));

        this._carts.add(new Cart(TYPE_ACE, COLOR_SPADE));
        this._carts.add(new Cart(TYPE_KING, COLOR_SPADE));
        this._carts.add(new Cart(TYPE_QUEEN, COLOR_SPADE));
        this._carts.add(new Cart(TYPE_JACK, COLOR_SPADE));
        this._carts.add(new Cart(TYPE_10, COLOR_SPADE));
        this._carts.add(new Cart(TYPE_9, COLOR_SPADE));
        this._carts.add(new Cart(TYPE_8, COLOR_SPADE));
        this._carts.add(new Cart(TYPE_7, COLOR_SPADE));

        this._carts.add(new Cart(TYPE_ACE, COLOR_HEART));
        this._carts.add(new Cart(TYPE_KING, COLOR_HEART));
        this._carts.add(new Cart(TYPE_QUEEN, COLOR_HEART));
        this._carts.add(new Cart(TYPE_JACK, COLOR_HEART));
        this._carts.add(new Cart(TYPE_10, COLOR_HEART));
        this._carts.add(new Cart(TYPE_9, COLOR_HEART));
        this._carts.add(new Cart(TYPE_8, COLOR_HEART));
        this._carts.add(new Cart(TYPE_7, COLOR_HEART));

        this._carts.add(new Cart(TYPE_ACE, COLOR_DIAMOND));
        this._carts.add(new Cart(TYPE_KING, COLOR_DIAMOND));
        this._carts.add(new Cart(TYPE_QUEEN, COLOR_DIAMOND));
        this._carts.add(new Cart(TYPE_JACK, COLOR_DIAMOND));
        this._carts.add(new Cart(TYPE_10, COLOR_DIAMOND));
        this._carts.add(new Cart(TYPE_9, COLOR_DIAMOND));
        this._carts.add(new Cart(TYPE_8, COLOR_DIAMOND));
        this._carts.add(new Cart(TYPE_7, COLOR_DIAMOND));
        
    }

    public void shuffle() {
        for (int i = 0; i < 10; i++) {
            Collections.shuffle(this._carts);
        }
    }

    public List<Cart> getCarts() {
        return this._carts;
    }

}
