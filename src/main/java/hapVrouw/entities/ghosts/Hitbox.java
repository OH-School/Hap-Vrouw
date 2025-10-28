package hapVrouw.entities.ghosts;

import hapVrouw.entities.tileMap.Muur;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import javafx.scene.paint.Color;

import java.util.List;

public class Hitbox extends RectangleEntity implements Collided, Collider{

    private Zijkanten zijkanten;
    private Ghosts parentGhost;

    public Hitbox(final Coordinate2D initialPosition, int Width, int Height, Zijkanten zijkanten, Ghosts parentGhost) {
        super(initialPosition);
        this.zijkanten = zijkanten;
        this.parentGhost = parentGhost;
        setWidth(Width);
        setHeight(Height);
        setFill(Color.TRANSPARENT);
    }

    @Override
    public void onCollision(List<Collider> colliders) {
        for (Collider collider : colliders) {
            if (collider instanceof Muur) {
                parentGhost.handleWallCollision(zijkanten);
                break;
            }
        }
    }
}