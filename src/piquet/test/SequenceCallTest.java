package piquet.test;

import static org.junit.Assert.*;

import org.junit.Test;
import piquet.*;
import piquet.calls.ICall;
import piquet.calls.SequenceCall;
import piquet.exceptions.IllegalCallException;

import static piquet.Cart.*;

/**
 * Created by jenko on 26.02.16.
 */
public class SequenceCallTest {

    @Test
    public void createCall () {

        IPlayer jens = new Player("Jens");
        IPlayer jessica = new Player("Jessica");

        Piquet game = new Piquet(jens, jessica, jens);

        game.createSets();

        ICall call = null;

        try {
            call = new SequenceCall(game, jens, new ICart[] {
                    new Cart(TYPE_JACK, COLOR_SPADE),
                    new Cart(TYPE_QUEEN, COLOR_SPADE),
                    new Cart(TYPE_KING, COLOR_SPADE),
                    new Cart(TYPE_ACE, COLOR_SPADE)
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            call.answer(new ICart[] {
                    new Cart(TYPE_9, COLOR_HEART),
                    new Cart(TYPE_10, COLOR_HEART),
                    new Cart(TYPE_JACK, COLOR_HEART)});

        } catch (IllegalCallException e) {

        }


    }

}
