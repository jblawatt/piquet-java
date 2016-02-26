package piquet;

import piquet.calls.ICall;
import piquet.exceptions.AlreadyChangedException;
import piquet.exceptions.InvalidOperationException;
import piquet.exceptions.ToManyChangesException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jenko on 09.02.16.
 */
public class Piquet {

    protected IPlayerControl _player1;
    protected IPlayerControl _player2;
    protected ISet _talon;

    protected IDeck _deck;
    protected List<ICall> _calls;

    protected IPlayer _currentPlayer;

    public Piquet(IPlayer player1, IPlayer player2, IPlayer startPlayer) {
        this._player1 = new PlayerControl(player1, player1.equals(startPlayer));
        this._player2 = new PlayerControl(player2, player2.equals(startPlayer));
        this._talon = new Set(null);
        this._deck = new Deck();
        this._calls = new ArrayList<ICall>();
        this._currentPlayer = startPlayer;
    }

    public void createSets() {
        IPlayerControl playerControl[];
        int current = 0;

        if (_player1.isStartPlayer()) {
            playerControl = new IPlayerControl[] {_player1, _player2};
        } else {
            playerControl = new IPlayerControl[] {_player2, _player1};
        }

        this._deck.shuffle();

        while (this._deck.size() > 8) {
            for (int i = 0; i < 2; i++) {
                playerControl[current].giveCart(this._deck.remove(0));
            }
            if (current == 0) {
                current = 1;
            } else {
                current = 0;
            }
        }

        while (this._deck.size() > 0) {
            this._talon.add(this._deck.remove(0));
        }

    }

    public IPlayerControl getPlayerControl(IPlayer player) {
        if (player.equals(this._player1.getPlayer())) {
            return this._player1;
        } else {
            return this._player2;
        }
    }

    public ISet getTalon() {
        return this._talon;
    }

    public void play() {
        this.createSets();
    }

    public IPlayerControl getPlayer1() {
        return this._player1;
    }

    public IPlayerControl getPlayer2() {
        return this._player2;
    }

    protected void validateChanges(IPlayerControl control, ICart[] carts) throws ToManyChangesException, AlreadyChangedException {
        int changeSize = carts.length;

        if (control.hasChanged()) {
            throw new AlreadyChangedException("Dieser Spieler hat bereits bewechselt.");
        }

        if (control.isStartPlayer()) {
            if (changeSize > 5) {
                throw new ToManyChangesException("Sie dürfen maximal 5 Karten wechseln.");
            }
        } else {
            if (changeSize > this._talon.size()) {
                throw new ToManyChangesException("Sie dürfen maximal " + this._talon.size() + " Karten wechseln.");
            }
        }
    }

    public void changeCarts(IPlayer player, ICart[] carts) throws ToManyChangesException, AlreadyChangedException {
        IPlayerControl control;
        ISet set;

        if (player.equals(_player1.getPlayer())) {
            control = _player1;
        } else {
            control = _player2;
        }

        set = control.getSet();

        this.validateChanges(control, carts);

        set.removeAll(Arrays.asList(carts));
        for (ICart c: carts) {
            set.add(this._talon.remove(0));
        }

        control.setChanged(true);
    }

    public void call(ICall call) throws InvalidOperationException {
        if (this._calls.size() > 0) {
            ICall lastCall = this._calls.get(this._calls.size() - 1);
            if (!lastCall.wasAnswered()) {
                throw new InvalidOperationException("Die letzte Meldung wurde noch nicht beantwortet.");
            }
        }
        this._calls.add(call);
    }

    public void answer(ICart[] carts) throws InvalidOperationException {
        if (this._calls.size() == 0) {
            throw new InvalidOperationException("Es steht keine Meldung für die Antwort zur Verfügung.");
        } else {
            ICall lastCall = this._calls.get(this._calls.size() - 1);
            if (lastCall.wasAnswered()) {
                throw new InvalidOperationException("Die letzte Meldung wurde bereits beantwortet.");
            } else {
                lastCall.setAnswer(carts);
            }
        }

    }

}
