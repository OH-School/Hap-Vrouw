package hapVrouw.entities.effectTiles.effectTiles;

import hapVrouw.entities.effectTiles.EffectTile;
import hapVrouw.entities.hapVrouw.HapVrouw;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;

public class SlowTile extends EffectTile {

    public SlowTile(Coordinate2D initialPosition, Size size) {
        super("sprites/action/SlowTile.png", initialPosition, size);
    }

    @Override
    public void tileAction(HapVrouw hapVrouw) {
        hapVrouw.setPlayerSpeed(hapVrouw.getStandardSpeed() * 0.7f);
        remove();
    }
}
