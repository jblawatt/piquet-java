package piquet;

import java.util.List;

/**
 * Created by jenko on 09.02.16.
 */
public class Piquet {

    protected IPlayer _player1;
    protected IPlayer _player2;

    protected ISet _setPlayer1;
    protected ISet _setPlayer2;
    protected ISet _talon;

    protected IDeck _deck;

    // protected Object _stack;

    public Piquet(IPlayer player1, IPlayer player2) {
        this._player1 = player1;
        this._player2 = player2;
        this._setPlayer1 = new Set(player1);
        this._setPlayer2 = new Set(player2);
        this._talon = new Set(null);
        this._deck = new Deck();
    }

    public void createSets() {
        ISet current = this._setPlayer1;

        this._deck.shuffle();

        while (this._deck.size() > 8) {
            for (int i = 0; i < 2; i++) {
                current.add(this._deck.remove(0));
            }
            if (current.equals(this._setPlayer1)) {
                current = this._setPlayer2;
            } else {
                current = this._setPlayer1;
            }
        }

        while (this._deck.size() > 0) {
            this._talon.add(this._deck.remove(0));
        }

    }

    public ISet getSetPlayer1() {
        return this._setPlayer1;
    }

    public ISet getSetPlayer2() {
        return this._setPlayer2;
    }

    public ISet getTalon() {
        return this._talon;
    }

    public void play() {

    }

}
