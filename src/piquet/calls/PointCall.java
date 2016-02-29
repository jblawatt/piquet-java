package piquet.calls;

import piquet.ICart;
import piquet.IPlayer;
import piquet.Piquet;
import piquet.comparators.PointCallComparator;
import piquet.exceptions.IllegalCallException;
import piquet.exceptions.IllegalPointCallException;
import piquet.exceptions.InvalidException;
import piquet.validators.SameColorValidator;

import java.util.Comparator;

public class PointCall extends Call {

    public final Integer ILLEGAL_POINT_CALL_COLORS = 2001;

    protected static final Integer POINTS_WINNER = 5;
    protected static final Integer POINTS_LOOSER_EQUALS = 0;

    protected final String NAME = "POINT CALL";

    public PointCall(Piquet game, IPlayer player, ICart[] carts) throws IllegalCallException {
        super(game, player, carts);
    }

    public String getName() {
        return NAME;
    }

    public void validate(ICart[] carts) throws IllegalPointCallException {
        if (carts == null) return;

        SameColorValidator validator = new SameColorValidator();
        try {
            validator.validate(carts);
        } catch (InvalidException e) {
            throw new IllegalPointCallException("", ILLEGAL_POINT_CALL_COLORS);
        }

    }

    public void answer(ICart[] carts) throws IllegalPointCallException {
        if (carts != null) {
            this.validate(carts);
            this._answer = carts;
        } else {
            this._answer = new ICart[] {};
        }

        this._answered = true;
    }

    public Integer getPlayer1Points() {
        Comparator<ICart[]> comp = new PointCallComparator();
        int compValue = comp.compare(this._call, this._answer);
        if (this._player.equals(this._game.getPlayer1().getPlayer())) {
            if (compValue > 0) {
                return POINTS_WINNER;
            } else {
                return POINTS_LOOSER_EQUALS;
            }
        } else {
            if (compValue < 0) {
                return POINTS_WINNER;
            } else {
                return POINTS_LOOSER_EQUALS;
            }
        }
    }

    public Integer getPlayer2Points() {
        Comparator<ICart[]> comp = new PointCallComparator();
        int compValue = comp.compare(this._call, this._answer);
        if (this._player.equals(this._game.getPlayer2().getPlayer())) {
            if (compValue > 0) {
                return POINTS_WINNER;
            } else {
                return POINTS_LOOSER_EQUALS;
            }
        } else {
            if (compValue < 0) {
                return POINTS_WINNER;
            } else {
                return POINTS_LOOSER_EQUALS;
            }
        }
    }

}
