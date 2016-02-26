package piquet.calls;

import piquet.ICart;
import piquet.IPlayer;
import piquet.Piquet;
import piquet.exceptions.IllegalPointCallException;
import piquet.exceptions.InvalidException;
import piquet.validators.SameColorValidator;

/**
 * Created by jenko on 26.02.16.
 */
public class PointCall /* implements ICall*/ {

    public final Integer ILLEGAL_POINT_CALL_COLORS = 2001;

    protected static final Integer POINTS = 5;

    protected Piquet _game;
    protected IPlayer _player;
    protected ICart[] _call;
    protected ICart[] _answer;
    protected Boolean _answered = false;

    protected final String NAME = "SEQUENCE CALL";

    public PointCall(Piquet game, IPlayer player, ICart[] carts) throws IllegalPointCallException {
        this._game = game;
        this._player = player;
        this._call = carts;
        this.validate(carts);
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



}
