package piquet;

import java.util.List;

/**
 * Created by jenko on 09.02.16.
 */
public interface IDeck extends List<ICart> {

    void shuffle();

}
