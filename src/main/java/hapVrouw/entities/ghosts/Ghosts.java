package hapVrouw.entities.ghosts;

<<<<<<< Updated upstream:src/main/java/hapVrouw/entities/ghosts/Ghosts.java
import hapVrouw.entities.tileMap.Muur;
=======
>>>>>>> Stashed changes:src/main/java/HapVrouw/entities/ghosts/Ghosts.java
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.scenes.SceneBorder;

<<<<<<< Updated upstream:src/main/java/hapVrouw/entities/ghosts/Ghosts.java
import java.util.List;
=======
>>>>>>> Stashed changes:src/main/java/HapVrouw/entities/ghosts/Ghosts.java
import java.util.Random;

public class Ghosts extends DynamicCompositeEntity implements SceneBorderCrossingWatcher {

    private Random random = new Random();
    private int[] directions = {0, 90, 180, 270};

    public Ghosts(Coordinate2D initialLocation) {
        super(initialLocation);
        setSpeed(0.2);
        setDirection(90);
    }

    @Override
    protected void setupEntities() {
        GhostsSprite ghostsSprite = new GhostsSprite("sprites/ghosts/picture.png",new Coordinate2D(getWidth() / 2 , getHeight() / 2 -80 ),0);
        addEntity(ghostsSprite);
        Hitbox hitboxLinks = new Hitbox(new Coordinate2D(getWidth() / 2 , getHeight() / 2 -80 ),1,35, Zijkanten.Links);
        addEntity(hitboxLinks);
        Hitbox hitboxRechts = new Hitbox(new Coordinate2D(getWidth() / 2 +30, getHeight() / 2 -80 ),1,35, Zijkanten.Rechts);
        addEntity(hitboxRechts);
        Hitbox hitboxBoven = new Hitbox(new Coordinate2D(getWidth() / 2 , getHeight() / 2 -80 ),30,1, Zijkanten.Boven);
        addEntity(hitboxBoven);
        Hitbox hitboxOnder = new Hitbox(new Coordinate2D(getWidth() / 2 , getHeight() / 2 - 45 ),30,1, Zijkanten.Onder);
        addEntity(hitboxOnder);
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
}

