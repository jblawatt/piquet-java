package piquet;

/**
 * Created by jenko on 09.02.16.
 */
public class Player implements IPlayer {

    protected String _name;
    protected String _uid;

    public Player(String name) {
        this._name = name;
        this._uid = "";
    }

    public String getName() {
        return this._name;
    }

    public String getUId() {
        return this._uid;
    }

}
