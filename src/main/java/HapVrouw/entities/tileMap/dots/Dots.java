package HapVrouw.entities.tileMap.dots;

import HapVrouw.entities.hapVrouw.HapVrouw;
import HapVrouw.entities.text.ScoreText;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

import java.util.List;


public abstract class Dots extends SpriteEntity implements Collider{
    public Dots(Coordinate2D initialLocation, Size size, String resource) {
        super(resource, initialLocation, size);
    }

    public abstract void addPoints(ScoreText scoreText);
}
