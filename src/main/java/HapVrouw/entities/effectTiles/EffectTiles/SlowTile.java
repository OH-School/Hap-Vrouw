package HapVrouw.entities.effectTiles.EffectTiles;

import HapVrouw.entities.effectTiles.EffectTile;
import HapVrouw.entities.hapVrouw.HapVrouw;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;

public class SlowTile extends EffectTile {

    public SlowTile(Coordinate2D initialPosition, Size size) {
        super("sprites/action/SlowTile.png", initialPosition, size);
    }

    @Override
    public void action(HapVrouw hapVrouw) {
        hapVrouw.setPlayerSpeed(hapVrouw.getStandardSpeed() * 0.1f);
        remove();
    }
}
