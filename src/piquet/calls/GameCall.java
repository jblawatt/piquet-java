package piquet.calls;

import piquet.ICart;
import piquet.IPlayer;
import piquet.Piquet;
import piquet.comparators.GameCallComparator;
import piquet.exceptions.IllegalCallException;

import java.util.Comparator;


public class GameCall extends Call {

    public static final String NAME = "GAME CALL";

    public GameCall(Piquet game, IPlayer player, ICart[] carts) throws IllegalCallException {
        super(game, player, carts);
    }

    public String getName() {
        return NAME;
    }

    public void validate(ICart[] carts) throws IllegalCallException {

    }

    public Integer getPlayer1Points() {
        int points = 0;
        Comparator<ICart> c = new GameCallComparator();
        if (this._player.equals(this._game.getPlayer1().getPlayer())) {
            points += 1;
        }
        if (this._player.equals(this._game.getPlayer1().getPlayer())) {
            if (c.compare(_call[0], _answer[0]) > 0) {
                points += 1;
            }
        }
        return points;
    }

    public Integer getPlayer2Points() {
        int points = 0;
        Comparator<ICart> c = new GameCallComparator();
        if (this._player.equals(this._game.getPlayer2().getPlayer())) {
            points += 1;
        }
        if (this._player.equals(this._game.getPlayer2().getPlayer())) {
            if (c.compare(_call[0], _answer[0]) > 0) {
                points += 1;
            }
        }
        return points;
    }

}
