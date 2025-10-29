package hapVrouw.entities.ghosts;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.EntitySpawner;

public class GhostSpawner extends EntitySpawner {
    private double x;
    private double y;


    public GhostSpawner(long intervalInMs, double x, double y) {
        super(intervalInMs);
        this.x = x;
        this.y = y;
    }

    @Override
    protected void spawnEntities() {
        spawn(new Ghosts((new Coordinate2D(x, y)),0));
    }
}
