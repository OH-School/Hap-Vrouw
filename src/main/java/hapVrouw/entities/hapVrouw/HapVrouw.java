package hapVrouw.entities.hapVrouw;

import com.github.hanyaeger.api.TimerContainer;
import hapVrouw.entities.dots.dots.BigDot;
import hapVrouw.entities.ghosts.GhostOranje;
import hapVrouw.entities.ghosts.Ghosts;
import hapVrouw.entities.ghosts.GhostPaars;
import hapVrouw.entities.ghosts.GhostRood;
import hapVrouw.entities.text.HealthText;
import hapVrouw.entities.text.ScoreText;
import hapVrouw.entities.effectTiles.EffectTile;
import hapVrouw.entities.text.Time;
import hapVrouw.entities.tileMap.Muur;
import hapVrouw.entities.dots.Dots;
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

public class HapVrouw extends DynamicSpriteEntity implements KeyListener, SceneBorderCrossingWatcher, Collided, TimerContainer {

    private float standardSpeed = 3f;
    private float speed = standardSpeed;
    private Coordinate2D previousLocation;
    public Coordinate2D initialLocation;
    private HealthText healthText;
    private int heath = 3;
    private ScoreText scoreText;
    private int score = 0;
    private boolean controlsReversed = false;
    private boolean isSuper = false;
    private Time superTimer;


    public HapVrouw(Coordinate2D initialLocation, HealthText healthText, ScoreText scoreText) {
        super("sprites/hapvrouw/hapvrouw.png", initialLocation, new Size(28), 8, 5);
        this.healthText = healthText;
        healthText.setHealthText(heath);
        this.scoreText = scoreText;
        scoreText.setScoreText(score);
        previousLocation = getAnchorLocation();
        this.initialLocation = initialLocation;
    }

    @Override
    public void onCollision(List<Collider> colliders) {
        for (Collider collider : colliders) {
            if (collider instanceof Muur) {
                setAnchorLocation(previousLocation);
                setSpeed(0);
                break;
            }
            if (collider instanceof Dots) {
                ((Dots) collider).addPoints(scoreText);
                if (collider instanceof BigDot) {
                    becomeSuper();
                }
            }

            if (collider instanceof EffectTile) {
                ((EffectTile) collider).action(this);
            }

            if (collider instanceof Ghosts) {
                System.out.println(" Ghost Hitbox");
//                System.out.println(ghosts.getRow());
                if (isSuper) {
                    ((Ghosts) collider).superRemove();
                    System.out.println(" Super Remove");
                } else {
                    if (collider instanceof GhostOranje) {
                        ((Ghosts) collider).action(this, scoreText);
                        System.out.println("action");

                    } else if (collider instanceof GhostPaars) {
                        controlsReversed = !controlsReversed;
                    } else if (collider instanceof GhostRood) {
                        heath--;
                        healthText.setHealthText(heath);
                        setAnchorLocation(new Coordinate2D(initialLocation.getX(), initialLocation.getY()));
                    }
                }

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
        if (superTimer != null && superTimer.getSeconden() <= 0) {
            isSuper = false;
            superTimer.remove();
        }
        if (pressedKeys.contains(KeyCode.LEFT)) {
            setMotion(speed, controlsReversed ? 90d : 270d);
            setAutoCycle(120, isSuper ? 5 : 1);
        } else if (pressedKeys.contains(KeyCode.RIGHT)) {
            setMotion(speed, controlsReversed ? 270d : 90d);
            setAutoCycle(120, isSuper ? 4 : 0);
        } else if (pressedKeys.contains(KeyCode.UP)) {
            setMotion(speed, controlsReversed ? 0d : 180d);
            setAutoCycle(120, isSuper ? 6 : 2);
        } else if (pressedKeys.contains(KeyCode.DOWN)) {
            setMotion(speed, controlsReversed ? 180d : 0d);
            setAutoCycle(120, isSuper ? 7 : 3);
        }
        else {
            setSpeed(0);
        }
    }

    public void setPlayerSpeed(float newSpeed) {
        this.speed = newSpeed;
        System.out.println(speed);
    }

    public void setLife(int health) {
        this.heath = health;
        healthText.setHealthText(health);
    }

    public int getLife() {
        return this.heath;
    }

    public float getStandardSpeed() {
        return this.standardSpeed;
    }

    private void becomeSuper() {
        isSuper = true;
        initTimers();
    }


    @Override
    public void setupTimers() {
        if (isSuper) {
            superTimer = new Time(5);
            addTimer(superTimer);
        }
        System.out.println(getTimers());
    }
}
