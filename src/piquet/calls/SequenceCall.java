package piquet.calls;

import piquet.*;
import piquet.comparators.SequenceCallComparator;
import piquet.exceptions.IllegalSequenceCallException;
import piquet.exceptions.InvalidException;
import piquet.exceptions.InvalidFollowupException;
import piquet.validators.FollowingTypeValidator;
import piquet.validators.IValidator;
import piquet.validators.SameColorValidator;

import java.util.*;

public class SequenceCall implements ICall, IPointable {

    public final Integer ILLEGAL_SEQUENCE_CALL_CARTS = 3001;
    public final Integer ILLEGAL_SEQUENCE_CALL_FOLLOWS = 3002;
    public final Integer ILLEGAL_SEQUENCE_CALL_COLORS = 3003;
    public final Integer ILLEGAL_SEQUENCE_CALL_UNKNOWN = 3004;

    protected static final Map<Integer, Integer> POINTS_MAP;
    static {
        Map<Integer, Integer> p = new HashMap<Integer, Integer>();
        p.put(3, 3);
        p.put(4, 4);
        p.put(5, 15);
        p.put(6, 16);
        p.put(7, 17);
        p.put(8, 18);
        POINTS_MAP = Collections.unmodifiableMap(p);
    }

    protected Piquet _game;
    protected IPlayer _player;
    protected ICart[] _call;
    protected ICart[] _answer;
    protected Boolean _answered = false;

    protected final String NAME = "SEQUENCE CALL";

    public SequenceCall(Piquet game, IPlayer player, ICart[] carts) throws IllegalSequenceCallException {
        this._game = game;
        this._player = player;
        this._call = carts;
        this.validate(carts);
    }

    public String getName() {
        return this.NAME;
    }

    public Integer getPlayer1Points() {
        Comparator<ICart[]> c = new SequenceCallComparator();
        if (this._player.equals(_game.getPlayer1().getPlayer())) {
            if (c.compare(_call, _answer) > 0) {
                return POINTS_MAP.get(_call.length);
            } else {
                return 0;
            }
        } else {
            if (c.compare(_answer, _call) > 0) {
                return POINTS_MAP.get(_call.length);
            } else {
                return 0;
            }
        }
    }

    public Integer getPlayer2Points() {
        Comparator<ICart[]> c = new SequenceCallComparator();
        if (this._player.equals(_game.getPlayer2().getPlayer())) {
            if (c.compare(_call, _answer) > 0) {
                return POINTS_MAP.get(_call.length);
            } else {
                return 0;
            }
        } else {
            if (c.compare(_answer, _call) > 0) {
                return POINTS_MAP.get(_call.length);
            } else {
                return 0;
            }
        }
    }

    protected void validate(ICart[] carts) throws IllegalSequenceCallException {
        Integer currentType = null;
        Integer currentColor = null;

        if (carts == null) return;

        if(carts.length < 3) {
            throw new IllegalSequenceCallException("Es müssen mindestens 3 Karten angesagt werden", ILLEGAL_SEQUENCE_CALL_CARTS);
        }
        // sortieren, dass auch alles in der richtigen reihenfolge ist
        Arrays.sort(carts, new CartTypeComparator());

        IValidator validator;

        validator = new SameColorValidator();
        try {
            validator.validate(carts);
        } catch (InvalidException e) {
            throw new IllegalSequenceCallException(
                    "Die Karten müssen alle von der gleichen Farbe sein.",
                    ILLEGAL_SEQUENCE_CALL_COLORS);
        }

        validator = new FollowingTypeValidator();
        try {
            validator.validate(carts);
        } catch (InvalidFollowupException e) {
            throw new IllegalSequenceCallException(
                    "Ungülige Kartenfolge. Auf " + e.getBase() + " darf nicht " + e.getFollowup() + " folgen.",
                    ILLEGAL_SEQUENCE_CALL_FOLLOWS);

        } catch (InvalidException e) {
            throw new IllegalSequenceCallException(
                    "Ungültige Aktion für den Sequence Call",
                    ILLEGAL_SEQUENCE_CALL_UNKNOWN);
        }

    }

    public void answer(ICart[] carts) throws IllegalSequenceCallException {
        if (carts != null) {
            this.validate(carts);
            this._answer = carts;
        } else {
            this._answer = null;
        }
        this._answered = true;
    }

    public Boolean wasAnswered() {
        return this._answered;
    }

    @Override
    public String toString() {
        return "<SequenceCall: answered=" + this._answered + ", player1=" + this.getPlayer1Points() + ", player2=" + this.getPlayer2Points() + ">";
    }

}
