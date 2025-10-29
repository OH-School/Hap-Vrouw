package hapVrouw.entities.ghosts;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.scenes.SceneBorder;
import hapVrouw.entities.ghosts.Sprites.GhostsSprite;
import hapVrouw.entities.hapVrouw.HapVrouw;
import hapVrouw.entities.text.HealthText;
import hapVrouw.entities.text.ScoreText;

import java.util.Random;

public abstract class Ghosts extends DynamicCompositeEntity implements SceneBorderCrossingWatcher, Collider {

    private Random random = new Random();
    private int[] directions = {0, 90, 180, 270};
    protected int row;


    public Ghosts(Coordinate2D initialLocation ) {
        super(initialLocation);

        setSpeed(0.5);
        setDirection(90);
    }

    public abstract void action(HapVrouw hapVrouw, ScoreText scoreText, HealthText healthText);

    @Override
    protected void setupEntities() {
        GhostsSprite ghostsSprite = new GhostsSprite("sprites/ghosts/picture.png",
                new Coordinate2D(getWidth() / 2, getHeight() / 2 - 80), row);
        addEntity(ghostsSprite);

        Hitbox hitboxLinks = new Hitbox(new Coordinate2D(getWidth() / 2, getHeight() / 2 - 80),
                1, 35, Zijkanten.Links, this);
        addEntity(hitboxLinks);

        Hitbox hitboxRechts = new Hitbox(new Coordinate2D(getWidth() / 2 + 30, getHeight() / 2 - 80),
                1, 35, Zijkanten.Rechts, this);
        addEntity(hitboxRechts);

        Hitbox hitboxBoven = new Hitbox(new Coordinate2D(getWidth() / 2, getHeight() / 2 - 80),
                30, 1, Zijkanten.Boven, this);
        addEntity(hitboxBoven);

        Hitbox hitboxOnder = new Hitbox(new Coordinate2D(getWidth() / 2, getHeight() / 2 - 45),
                30, 1, Zijkanten.Onder, this);
        addEntity(hitboxOnder);
    }



    public void handleWallCollision(Zijkanten zijkant) {
        double stepBackDistance = 5;

        switch (zijkant) {
            case Boven:
                setAnchorLocation(new Coordinate2D(
                        getAnchorLocation().getX(),
                        getAnchorLocation().getY() + stepBackDistance
                ));
                break;

            case Onder:
                setAnchorLocation(new Coordinate2D(
                        getAnchorLocation().getX(),
                        getAnchorLocation().getY() - stepBackDistance
                ));
                break;

            case Links:
                setAnchorLocation(new Coordinate2D(
                        getAnchorLocation().getX() + stepBackDistance,
                        getAnchorLocation().getY()
                ));
                break;

            case Rechts:
                setAnchorLocation(new Coordinate2D(
                        getAnchorLocation().getX() - stepBackDistance,
                        getAnchorLocation().getY()
                ));
                break;
        }

        int newDirection = directions[random.nextInt(directions.length)];
        setDirection(newDirection);
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder sceneBorder) {
        switch (sceneBorder) {
            case LEFT:
                setAnchorLocationX(getSceneWidth());
                break;
            case RIGHT:
                setAnchorLocationX(-16);
                break;
        }
    }

    public void superRemove() {
        this.remove();
    }


}

