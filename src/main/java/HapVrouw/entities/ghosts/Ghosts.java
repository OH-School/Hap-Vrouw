package HapVrouw.entities.ghosts;

import HapVrouw.entities.tileMap.Muur;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ghosts extends DynamicSpriteEntity implements Collided, SceneBorderCrossingWatcher, Collider {

    private Random random = new Random();
    private int[] directions = {0, 90, 180, 270};
    private double currentDirection;
    private final double STEP_BACK_DISTANCE = 50.0;
    private boolean isColliding = false;
    private int collisionCooldown = 0;

    protected Ghosts(String resource, Coordinate2D location) {
        super(resource, location, new Size(43), 3, 5);
        setSpeed(0.5);
        System.out.println(location);
        currentDirection = directions[random.nextInt(4)];
        setDirection(currentDirection);
    }

    @Override
    public void onCollision(List<Collider> list) {
        if (collisionCooldown > 0) {
            collisionCooldown--;
            return;
        }

        for (Collider collider : list) {
            if (collider instanceof Muur && !isColliding) {
                isColliding = true;
                stepBack();
                chooseValidDirection();
                collisionCooldown = 1;
                isColliding = false;
                break;
            }
        }

    }

    private void stepBack() {
        Coordinate2D currentPos = getAnchorLocation();

        double radians = Math.toRadians(currentDirection + 180);

        double newX = currentPos.getX() + Math.sin(radians) * STEP_BACK_DISTANCE;
        double newY = currentPos.getY() - Math.cos(radians) * STEP_BACK_DISTANCE;

        setAnchorLocation(new Coordinate2D(newX, newY));
    }

    private void chooseValidDirection() {
        List<Double> validDirections = new ArrayList<>();

        double oppositeDirection = (currentDirection + 180) % 360;
        validDirections.add(oppositeDirection);

        double perpendicular1 = (currentDirection + 90) % 360;
        double perpendicular2 = (currentDirection + 270) % 360;
        validDirections.add(perpendicular1);
        validDirections.add(perpendicular2);

        double newDirection = validDirections.get(random.nextInt(validDirections.size()));

        currentDirection = newDirection;
        setDirection(currentDirection);
//        System.out.println("Nieuwe richting na botsing: " + currentDirection);
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