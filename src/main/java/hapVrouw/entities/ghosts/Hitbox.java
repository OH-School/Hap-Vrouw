package hapVrouw.entities.ghosts;

import hapVrouw.entities.dots.Dots;
import hapVrouw.entities.effectTiles.EffectTile;
import hapVrouw.entities.tileMap.Muur;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import javafx.scene.paint.Color;

import java.util.List;

public class Hitbox extends RectangleEntity implements Collided {

    private Zijkanten zijkanten;
    private int Width = 0;
    private int Height = 0;
    public Hitbox(final Coordinate2D initialPosition, int Width, int Height, Zijkanten zijkanten) {
        super(initialPosition);
        this.zijkanten = zijkanten;
        setWidth(Width);
        setHeight(Height);
        setFill(Color.RED);
    }

    @Override
    public void onCollision(List<Collider> colliders) {
       for (Collider collider : colliders) {
           if (collider instanceof Muur) {
               if (zijkanten == Zijkanten.Rechts ) {

               }
               else if (zijkanten == Zijkanten.Links ) {

               }
               else if (zijkanten == Zijkanten.Boven) {

               }
               else if (zijkanten == Zijkanten.Onder) {

               }
           }
       }
    }
}
