package piquet.test;

import org.junit.Test;
import piquet.*;
import piquet.Set;
import piquet.calls.*;

import java.util.*;

import static piquet.Cart.*;
import static org.junit.Assert.*;

public class PiquetTest {

    public static Piquet createGame() {
        IPlayer jens = new Player("Jens");
        IPlayer jessica = new Player("Jessica");

        Piquet game = new Piquet(jens, jessica, jens);

        game.createSets();
        return game;
    }

    @Test
    public void testPiquet () {

        Piquet game = PiquetTest.createGame();

        assertEquals(game.getTalon().size(), 8);
        assertEquals(game.getPlayer1().getSet().size(), 12);
        assertEquals(game.getPlayer2().getSet().size(), 12);

        Random random = new Random();

        List<ICart> p1Changes = new ArrayList<ICart>();
        ICart[] p1ChangesArr = new ICart[5];
        ISet p1Set = game.getPlayer1().getSet();

        while (p1Changes.size() < 5) {
            ICart choice = p1Set.get(random.nextInt(p1Set.size()));
            if (!p1Changes.contains(choice)) {
                p1Changes.add(choice);
            }
        }

        try {
            game.changeCarts(game.getPlayer1().getPlayer(), p1Changes.toArray(p1ChangesArr));
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        List<ICart> p2Changes = new ArrayList<ICart>();
        ICart[] p2ChangesArr = new ICart[3];
        ISet p2Set = game.getPlayer2().getSet();

        while (p2Changes.size() < 3) {
            ICart choice = p2Set.get(random.nextInt(p2Set.size()));
            if (!p2Changes.contains(choice)) {
                p2Changes.add(choice);
            }
        }

        try {
            game.changeCarts(game.getPlayer2().getPlayer(), p2Changes.toArray(p2ChangesArr));
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        assertEquals(game.getTalon().size(), 0);
        assertEquals(game.getPlayer1().getSet().size(), 12);
        assertEquals(game.getPlayer2().getSet().size(), 12);

        for (ICart c: game.getPlayer1().getSet()) {
            // System.out.println("p1.giveCart(new Cart(" + TYPE_MAP.get(c.getType()) + ", " + COLOR_MAP.get(c.getColor()) + "));");
        }
        System.out.println("-------------------");
        for (ICart c: game.getPlayer2().getSet()) {
            // System.out.println("p2.giveCart(new Cart(" + TYPE_MAP.get(c.getType()) + ", " + COLOR_MAP.get(c.getColor()) + "));");
        }
    }

    @Test
    public void gameTest () {
        IPlayer jens = new Player("Jens");
        IPlayer jessica = new Player("Jessica");

        Piquet game = new Piquet(jens, jessica, jens);

        IPlayerControl p1 = game.getPlayer1();
        p1.giveCart(new Cart(TYPE_KING, COLOR_CROSS));  // 0
        p1.giveCart(new Cart(TYPE_KING, COLOR_DIAMOND)); // 1
        p1.giveCart(new Cart(TYPE_9, COLOR_CROSS)); // 2
        p1.giveCart(new Cart(TYPE_QUEEN, COLOR_HEART)); // 3
        p1.giveCart(new Cart(TYPE_7, COLOR_CROSS)); // 4
        p1.giveCart(new Cart(TYPE_9, COLOR_SPADE)); // 5
        p1.giveCart(new Cart(TYPE_JACK, COLOR_DIAMOND)); // 6
        p1.giveCart(new Cart(TYPE_QUEEN, COLOR_DIAMOND)); // 7
        p1.giveCart(new Cart(TYPE_9, COLOR_HEART)); // 8
        p1.giveCart(new Cart(TYPE_ACE, COLOR_HEART)); // 9
        p1.giveCart(new Cart(TYPE_9, COLOR_DIAMOND)); // 10
        p1.giveCart(new Cart(TYPE_ACE, COLOR_SPADE));  // 11

        IPlayerControl p2 = game.getPlayer2();
        p2.giveCart(new Cart(TYPE_JACK, COLOR_CROSS));
        p2.giveCart(new Cart(TYPE_KING, COLOR_HEART));
        p2.giveCart(new Cart(TYPE_7, COLOR_DIAMOND));
        p2.giveCart(new Cart(TYPE_QUEEN, COLOR_SPADE));
        p2.giveCart(new Cart(TYPE_KING, COLOR_SPADE));
        p2.giveCart(new Cart(TYPE_10, COLOR_CROSS));
        p2.giveCart(new Cart(TYPE_7, COLOR_HEART));
        p2.giveCart(new Cart(TYPE_8, COLOR_HEART));
        p2.giveCart(new Cart(TYPE_ACE, COLOR_CROSS));
        p2.giveCart(new Cart(TYPE_8, COLOR_DIAMOND));
        p2.giveCart(new Cart(TYPE_10, COLOR_HEART));
        p2.giveCart(new Cart(TYPE_JACK, COLOR_HEART));

        try {
            // call: 4 x Karo
            game.call(new PointCall(game, game.getPlayer1().getPlayer(), new ICart[] {
                p1.getSet().get(1), p1.getSet().get(6), p1.getSet().get(7), p1.getSet().get(10)
            }));
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        try {
            // anser: 5 x Herz
            game.answer(new ICart[] {
                p2.getSet().get(1), p2.getSet().get(6), p2.getSet().get(7), p2.getSet().get(10), p2.getSet().get(11)
            });
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        ICall lastCall = game.lastCall();
        assertEquals(lastCall.getPlayer1Points(), (Integer)0);
        assertEquals(lastCall.getPlayer2Points(), (Integer)5);

        // -------------------------------------------

        try {
            // call: karo -> könig, dame, bube
            game.call(new SequenceCall(game, game.getPlayer1().getPlayer(), new ICart[] {
                p1.getSet().get(1), p1.getSet().get(7), p1.getSet().get(6)
            }));
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        try {
            // call: null
            game.answer(null);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        lastCall = game.lastCall();
        assertEquals(lastCall.getPlayer1Points(), (Integer)3);
        assertEquals(lastCall.getPlayer2Points(), (Integer)0);


        try {
            game.call(new GameCall(game, jens, new ICart[] {}));
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

    }

}
