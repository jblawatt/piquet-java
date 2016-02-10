package piquet;

/**
 * Created by jenko on 09.02.16.
 */
public class Program {

    public static void main (String[] args) {
        Piquet game = new Piquet(
            new Player("Jens"),
            new Player("Jessica"));
        game.play();
    }

}
