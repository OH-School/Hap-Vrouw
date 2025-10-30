package hapVrouw.entities.effectTiles.effectTiles;

import hapVrouw.entities.effectTiles.EffectTile;
import hapVrouw.entities.hapVrouw.HapVrouw;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;

public class HeartTile extends EffectTile {

    public HeartTile(Coordinate2D initialPosition, Size size) {
        super("sprites/action/Health.png", initialPosition, size);
    }

    @Override
    public void tileAction(HapVrouw hapVrouw) {
        hapVrouw.setLife(hapVrouw.getLife() + 1);
        remove();
    }
}
