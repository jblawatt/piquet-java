package piquet;

import java.util.*;

public class Set extends ArrayList<ICart> implements ISet {

    protected IPlayer _player;

    public Set (IPlayer player) {
        super();
        this._player = player;
    }

    public void setPlayer(IPlayer player) {
        this._player = player;
    }

    public IPlayer getPlayer() {
        return this._player;
    }

}
