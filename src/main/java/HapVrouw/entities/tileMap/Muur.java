package HapVrouw.entities.tileMap;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public class Muur extends SpriteEntity implements Collider {
    public Muur(Coordinate2D initialLocation, Size size, String resource) {
        super(resource, initialLocation, size);
    }
}
