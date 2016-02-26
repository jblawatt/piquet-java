package piquet;

import piquet.ICart;
import piquet.IPlayer;
import piquet.ISet;
import piquet.Set;

public class PlayerControl implements IPlayerControl {

    protected ISet _set;
    protected IPlayer _player;

    protected Boolean _isStartPlayer;
    protected Boolean _changed;

    public PlayerControl(IPlayer player, Boolean isStartPlayer) {
        this._player = player;
        this._set = new Set(player);
        this._isStartPlayer = isStartPlayer;
        this._changed = false;
    }

    public void setChanged(Boolean value) {
        this._changed = value;
    }

    public Boolean hasChanged() {
        return this._changed;
    }

    public void giveCart(ICart cart) {
        this._set.add(cart);
    }

    public IPlayer getPlayer() {
        return this._player;
    }

    public Boolean isStartPlayer() {
        return this._isStartPlayer;
    }

    public ISet getSet() {
        return this._set;
    }

}
