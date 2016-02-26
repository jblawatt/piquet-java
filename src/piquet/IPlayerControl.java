package piquet;

/**
 * Created by jenko on 26.02.16.
 */
public interface IPlayerControl {

    void giveCart(ICart cart);

    IPlayer getPlayer();

    Boolean hasChanged();

    void setChanged(Boolean value);

    Boolean isStartPlayer();

    ISet getSet();

}
