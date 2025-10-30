package hapVrouw.entities.effectTiles.effectTiles;

import hapVrouw.entities.effectTiles.EffectTile;
import hapVrouw.entities.hapVrouw.HapVrouw;
import hapVrouw.entities.text.Time;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;

public class TimeTile extends EffectTile {

    private final Time gameTime;

    public TimeTile(Coordinate2D initialPosition, Size size, Time time) {
        super("sprites/action/TimeTile.png", initialPosition, size);
        this.gameTime = time;
    }

    @Override
    public void tileAction(HapVrouw hapVrouw) {
        gameTime.setSeconden(gameTime.getSeconden() + 5);
        remove();
    }
}
