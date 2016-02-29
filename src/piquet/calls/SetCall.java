package piquet.calls;

import piquet.ICart;
import piquet.IPlayer;
import piquet.Piquet;
import piquet.comparators.SetComparator;
import piquet.exceptions.IllegalCallException;
import piquet.exceptions.InvalidException;
import piquet.validators.IValidator;
import piquet.validators.SetValidator;

import java.util.Comparator;


public class SetCall extends Call {

    protected final static String NAME = "SET CALL";

    public SetCall(Piquet game, IPlayer player, ICart[] carts) throws IllegalCallException {
        super(game, player, carts);
    }

    public String getName() {
        return NAME;
    }

    public void validate(ICart[] carts) throws IllegalCallException {
        IValidator validator = new SetValidator();
        try {
            validator.validate(carts);
        } catch (InvalidException e) {
            throw new IllegalCallException("Die Karten sind kein gültiges Set", 4001);
        }
    }

    protected Integer getPoints(int setLength) {
        if (setLength == 4) {
            return 14;
        } else {
            return 3;
        }
    }

    public Integer getPlayer1Points() {
        Comparator<ICart[]> c = new SetComparator();
        if(this._player.equals(this._game.getPlayer1().getPlayer())) {
            if (c.compare(this._call, this._answer) > 0) {
                return this.getPoints(this._call.length);
            } else {
                return 0;
            }
        } else {
            if (c.compare(this._call, this._answer) < 0) {
                return this.getPoints(this._call.length);
            } else {
                return 0;
            }
        }
    }

    public Integer getPlayer2Points() {
        Comparator<ICart[]> c = new SetComparator();
        if(this._player.equals(this._game.getPlayer2().getPlayer())) {
            if (c.compare(this._call, this._answer) > 0) {
                return this.getPoints(this._call.length);
            } else {
                return 0;
            }
        } else {
            if (c.compare(this._call, this._answer) < 0) {
                return this.getPoints(this._call.length);
            } else {
                return 0;
            }
        }
    }

}
