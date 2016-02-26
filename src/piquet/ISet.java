package piquet;

import java.util.List;

/**
 * Created by jenko on 09.02.16.
 */
public interface ISet extends List<ICart> {

    IPlayer getPlayer();
    void setPlayer(IPlayer player);

}
