package HapVrouw.entities.effectTiles.EffectTiles;

import HapVrouw.entities.effectTiles.EffectTile;
import HapVrouw.entities.hapVrouw.HapVrouw;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;

public class SpeedTile extends EffectTile {

    public SpeedTile(Coordinate2D initialPosition, Size size) {
        super("sprites/action/SpeedTile.png", initialPosition, size);
    }

    @Override
    public void action(HapVrouw hapVrouw) {
        hapVrouw.setPlayerSpeed(hapVrouw.getStandardSpeed() * 1.3f);
        remove();
    }
}
