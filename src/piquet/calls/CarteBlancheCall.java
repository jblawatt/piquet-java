package piquet.calls;

import piquet.ICart;
import piquet.IPlayer;
import piquet.Piquet;
import piquet.exceptions.IllegalCallException;
import piquet.exceptions.InvalidException;
import piquet.validators.CarteBlancheValidator;
import piquet.validators.IValidator;

/**
 * Created by jenko on 29.02.16.
 */
public class CarteBlancheCall extends Call {

    protected static final Integer POINTS = 10;

    protected static final String NAME = "CARTE BLANCHE CALL";

    public CarteBlancheCall(Piquet game, IPlayer player, ICart[] carts) throws IllegalCallException {
        super(game, player, carts);
        this._answered = true;
    }

    public String getName() {
        return NAME;
    }

    public void validate(ICart[] carts) throws IllegalCallException {
        IValidator validator = new CarteBlancheValidator();
        try {
            validator.validate(carts);
        } catch (InvalidException e) {
            throw new IllegalCallException("Ungültige Karten für eine Carte Blanche", 1001);
        }
    }

    public void answer(ICart[] carts) throws IllegalCallException {
        throw new IllegalCallException("Carte Blanche kann nicht beantwortet werden", 1002);
    }

    public Integer getPlayer1Points() {
        if(this._player.equals(this._game.getPlayer1().getPlayer())) {
            return POINTS;
        } else {
            return 0;
        }
    }

    public Integer getPlayer2Points() {
        if(this._player.equals(this._game.getPlayer2().getPlayer())) {
            return POINTS;
        } else {
            return 0;
        }
    }


}
