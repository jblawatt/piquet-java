package piquet.test;

import org.junit.Test;

import piquet.*;

import java.util.List;

import static org.junit.Assert.*;

public class ShuffleTest {

    @Test
    public void createSets() {

        Piquet game = new Piquet(new Player("Jens"), new Player("Jessica"));

        game.createSets();

        assertEquals(game.getSetPlayer1().size(), 12);
        assertEquals(game.getSetPlayer2().size(), 12);
        assertEquals(game.getTalon().size(), 8);
    }

}
