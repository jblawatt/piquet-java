package piquet;

import java.util.ArrayList;
import java.util.Collections;

import static piquet.Cart.*;

public class Deck extends ArrayList<ICart> implements IDeck {

    public Deck() {
        this.add(new Cart(TYPE_ACE, COLOR_CROSS));
        this.add(new Cart(TYPE_KING, COLOR_CROSS));
        this.add(new Cart(TYPE_QUEEN, COLOR_CROSS));
        this.add(new Cart(TYPE_JACK, COLOR_CROSS));
        this.add(new Cart(TYPE_10, COLOR_CROSS));
        this.add(new Cart(TYPE_9, COLOR_CROSS));
        this.add(new Cart(TYPE_8, COLOR_CROSS));
        this.add(new Cart(TYPE_7, COLOR_CROSS));

        this.add(new Cart(TYPE_ACE, COLOR_SPADE));
        this.add(new Cart(TYPE_KING, COLOR_SPADE));
        this.add(new Cart(TYPE_QUEEN, COLOR_SPADE));
        this.add(new Cart(TYPE_JACK, COLOR_SPADE));
        this.add(new Cart(TYPE_10, COLOR_SPADE));
        this.add(new Cart(TYPE_9, COLOR_SPADE));
        this.add(new Cart(TYPE_8, COLOR_SPADE));
        this.add(new Cart(TYPE_7, COLOR_SPADE));

        this.add(new Cart(TYPE_ACE, COLOR_HEART));
        this.add(new Cart(TYPE_KING, COLOR_HEART));
        this.add(new Cart(TYPE_QUEEN, COLOR_HEART));
        this.add(new Cart(TYPE_JACK, COLOR_HEART));
        this.add(new Cart(TYPE_10, COLOR_HEART));
        this.add(new Cart(TYPE_9, COLOR_HEART));
        this.add(new Cart(TYPE_8, COLOR_HEART));
        this.add(new Cart(TYPE_7, COLOR_HEART));

        this.add(new Cart(TYPE_ACE, COLOR_DIAMOND));
        this.add(new Cart(TYPE_KING, COLOR_DIAMOND));
        this.add(new Cart(TYPE_QUEEN, COLOR_DIAMOND));
        this.add(new Cart(TYPE_JACK, COLOR_DIAMOND));
        this.add(new Cart(TYPE_10, COLOR_DIAMOND));
        this.add(new Cart(TYPE_9, COLOR_DIAMOND));
        this.add(new Cart(TYPE_8, COLOR_DIAMOND));
        this.add(new Cart(TYPE_7, COLOR_DIAMOND));

        this.shuffle();

    }

    public void shuffle() {
        for (int i = 0; i < 10; i++) {
            Collections.shuffle(this);
        }
    }

}
