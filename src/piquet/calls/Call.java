package piquet.calls;

import piquet.ICart;
import piquet.IPlayer;
import piquet.Piquet;
import piquet.exceptions.IllegalCallException;
import piquet.exceptions.IllegalPointCallException;


public abstract class Call implements ICall {

    protected Piquet _game;
    protected IPlayer _player;
    protected ICart[] _call;
    protected ICart[] _answer;
    protected Boolean _answered = false;

    public Call(Piquet game, IPlayer player, ICart[] carts) throws IllegalCallException {
        this._game = game;
        this._player = player;
        this._call = carts;
        this.validate(carts);
    }

    public void answer(ICart[] carts) throws IllegalCallException {
        if (carts != null) {
            this.validate(carts);
            this._answer = carts;
        } else {
            this._answer = new ICart[] {};
        }
        this._answered = true;
    }

    public Boolean wasAnswered() {
        return this._answered;
    }

    abstract void validate(ICart[] carts) throws IllegalCallException;

}
