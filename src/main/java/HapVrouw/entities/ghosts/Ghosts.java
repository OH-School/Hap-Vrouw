package HapVrouw.entities.ghosts;

import HapVrouw.entities.hapVrouw.HapVrouw;
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

public class Ghosts extends DynamicSpriteEntity implements Collided, SceneBorderCrossingWatcher, Collider{

    private Random random = new Random();
    private int[] directions = {0, 90, 180, 270};
    private double currentDirection;


    protected Ghosts(String resource, Coordinate2D location) {
        super(resource, location, new Size(35), 3, 5);
        setSpeed(0.2);
        System.out.println(location);
        currentDirection = directions[random.nextInt(4)];
        setDirection(270);
    }

    @Override
    public void onCollision(List<Collider> list) {


        for (Collider collider : list) {
            if (collider instanceof Muur) {
                Muur muur = (Muur) collider;

                // Definieer alle kanten van de muur
                double muurBovenKant = muur.getAnchorLocation().getY();
                double muurOnderKant = muur.getAnchorLocation().getY() + muur.getHeight();
                double muurLinkerKant = muur.getAnchorLocation().getX();
                double muurRechterKant = muur.getAnchorLocation().getX() + muur.getWidth();

                // En voor de ghost
                double ghostBovenKant = this.getAnchorLocation().getY();
                double ghostOnderKant = this.getAnchorLocation().getY() + this.getHeight();
                double ghostLinkerKant = this.getAnchorLocation().getX();
                double ghostRechterKant = this.getAnchorLocation().getX() + this.getWidth();

////                 Check botsing met onderkant van muur (ghost komt van onder)
//                if (ghostBovenKant <= muurOnderKant && ghostBovenKant >= muurBovenKant) {
//                    setAnchorLocationY(getAnchorLocation().getY() + 4);
//                    setDirection(directions[random.nextInt(4)]);
//                    break;
//                }
//
//                // Check botsing met bovenkant van muur (ghost komt van boven)
//                if (ghostOnderKant >= muurBovenKant && ghostOnderKant <= muurOnderKant) {
//                    setAnchorLocationY(getAnchorLocation().getY() - 4);
//                    setDirection(directions[random.nextInt(4)]);
//                    break;
//                }

                // Check botsing met rechterkant van muur (ghost komt van rechts)
                if (ghostLinkerKant <= muurRechterKant && ghostLinkerKant >= muurLinkerKant) {
                    setAnchorLocationX(getAnchorLocation().getX() + 4);
                    setDirection(directions[random.nextInt(4)]);
                    break;
                }

                // Check botsing met linkerkant van muur (ghost komt van links)
                if (ghostRechterKant >= muurLinkerKant && ghostRechterKant <= muurRechterKant) {
                    setAnchorLocationX(getAnchorLocation().getX() - 4);
                    setDirection(directions[random.nextInt(4)]);
                    break;
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
        }
    }
}