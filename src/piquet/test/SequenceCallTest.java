package piquet.test;

import org.junit.Test;
import piquet.ICart;
import piquet.IPlayer;
import piquet.Piquet;
import piquet.Player;
import piquet.calls.ICall;
import piquet.calls.SequenceCall;

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

        try {
            ICall call = new SequenceCall(game, jens, new ICart[] {});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
