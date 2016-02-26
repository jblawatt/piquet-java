package piquet;

/**
 * Created by jenko on 09.02.16.
 */
public class Program {

    public static void main (String[] args) {

        IPlayer p1 = new Player(args[0]);
        IPlayer p2 = new Player(args[1]);

        Piquet game = new Piquet(p1, p2, p1);
        game.play();
    }

}
