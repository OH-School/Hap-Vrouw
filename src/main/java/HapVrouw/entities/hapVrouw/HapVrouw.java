package HapVrouw.entities.hapVrouw;

import HapVrouw.entities.effectTiles.EffectTile;
import HapVrouw.entities.ghosts.GhostRood;
import HapVrouw.entities.tileMap.Muur;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;

import java.util.List;
import java.util.Set;

public class HapVrouw extends DynamicSpriteEntity implements KeyListener, SceneBorderCrossingWatcher, Collided {

    private float standardSpeed = 3f;
    private float speed = standardSpeed;
    private Coordinate2D previousLocation;

    public HapVrouw(Coordinate2D initialLocation) {
        super("sprites/hapvrouw/hapvrouw.png", initialLocation, new Size(28), 8, 5);
        previousLocation = getAnchorLocation();
    }

    @Override
    public void onCollision(List<Collider> colliders) {
        for (Collider collider : colliders) {
            if (collider instanceof Muur) {
                setAnchorLocation(previousLocation);
                setSpeed(0);
                break;
            }
            if (collider instanceof EffectTile) {
                ((EffectTile) collider).action(this);
            }

        }
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
            case TOP:
                setAnchorLocationY(getSceneHeight());
                break;
            case BOTTOM:
                setAnchorLocationY(-16);
                break;
        }
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
        previousLocation = getAnchorLocation();

        if (pressedKeys.contains(KeyCode.LEFT)) {
            setMotion(speed, 270d);
            setAutoCycle(120, 1);
        } else if (pressedKeys.contains(KeyCode.RIGHT)) {
            setMotion(speed, 90d);
            setAutoCycle(120, 0);
        } else if (pressedKeys.contains(KeyCode.UP)) {
            setMotion(speed, 180d);
            setAutoCycle(120, 2);
        } else if (pressedKeys.contains(KeyCode.DOWN)) {
            setMotion(speed, 0d);
            setAutoCycle(120, 3);
        } else {
            setSpeed(0);
        }
    }

    // 👇 Deze setter gebruiken we in SpeedTile
    public void setPlayerSpeed(float newSpeed) {
        this.speed = newSpeed;
        System.out.println(speed);
    }

    // 👇 Getter voor als je de huidige snelheid nodig hebt
    public float getStandardSpeed() {
        return this.standardSpeed;
    }
}
