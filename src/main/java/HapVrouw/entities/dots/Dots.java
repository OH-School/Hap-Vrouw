package HapVrouw.entities.dots;

import HapVrouw.entities.text.ScoreText;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;


public abstract class Dots extends SpriteEntity implements Collider{

    protected static int nDots = 0;

    public Dots(String resource, Coordinate2D initialPosition, Size size) {
        super(resource, initialPosition, size);
        nDots++;
        System.out.println("new Dot");
    }

    public abstract void addPoints(ScoreText scoreText);
}
