package HapVrouw.entities.effectTiles;

import HapVrouw.entities.hapVrouw.HapVrouw;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public abstract class EffectTile extends SpriteEntity implements Collider {

    protected EffectTile(String resource, Coordinate2D initialPosition, Size size) {
        super(resource, initialPosition, size);
    }

    public abstract void action(HapVrouw hapVrouw);
}
