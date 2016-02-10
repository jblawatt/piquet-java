package piquet;

import java.util.*;

/**
 * Created by jenko on 09.02.16.
 */
public class Set implements ISet {

    protected IPlayer _player;
    protected List<ICart> _set;

    public Set(IPlayer player) {
        this._player = player;
        this._set = new ArrayList<ICart>();
    }

    public void add(ICart cart) {
        this._set.add(cart);
    }

    public int size() {
        return this._set.size();
    }

}
