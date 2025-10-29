package hapVrouw.entities.ghosts.Sprites;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public class GhostsSprite extends DynamicSpriteEntity {

    public GhostsSprite(String resource, Coordinate2D initialLocation, int row) {
        super(resource, initialLocation, new Size(35), 3, 5);
        setAutoCycle(100, row);
    }




}
