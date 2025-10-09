package HapVrouw.entities.hapVrouw;

import HapVrouw.entities.tileMap.Muur;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;
import HapVrouw.Game;

import java.util.List;
import java.util.Set;

public class HapVrouw extends DynamicSpriteEntity implements KeyListener, SceneBorderCrossingWatcher, Collided, Collider {

    private Game game;
    private float speed = 2f;
    private Coordinate2D previousLocation;

    public HapVrouw(Coordinate2D initialLocation) {
        super("sprites/hapvrouw/hapvrouw.png", initialLocation, 8, 5);
        this.game = game;
        setAutoCycle(120, 0);
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
        }
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder sceneBorder) {
        switch (sceneBorder) {
            case LEFT:
                setAnchorLocationX(getSceneWidth());
                break;
            case RIGHT:
                setAnchorLocationX(-32);
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
}
