package piquet.test;

import org.junit.Test;

import piquet.*;
import piquet.exceptions.AlreadyChangedException;
import piquet.exceptions.ToManyChangesException;

import static org.junit.Assert.*;

public class ShuffleTest {

    @Test
    public void createSets() {

        IPlayer jens = new Player("Jens");
        IPlayer jessica = new Player("Jessica");

        Piquet game = new Piquet(jens, jessica, jens);

        game.createSets();

        assertEquals(game.getPlayer1().getSet().size(), 12);
        assertEquals(game.getPlayer2().getSet().size(), 12);
        assertEquals(game.getTalon().size(), 8);
    }

    @Test
    public void deckShuffle() {
        IDeck deck = new Deck();
        deck.shuffle();
    }

    @Test
    public void testChangeCarts() {

        IPlayer jens = new Player("Jens");
        IPlayer jessica = new Player("Jessica");

        Piquet game = new Piquet(jens, jessica, jens);

        game.createSets();

        IPlayerControl p1Ctrl = game.getPlayer1();
        ISet setP1 = p1Ctrl.getSet();

        ICart[] changesP1 = {setP1.get(0), setP1.get(1), setP1.get(2), setP1.get(3), setP1.get(4)};

        try {
            game.changeCarts(p1Ctrl.getPlayer(), changesP1);
        } catch (ToManyChangesException | AlreadyChangedException e) {
            System.out.println(e.toString());
        }

    }

}
