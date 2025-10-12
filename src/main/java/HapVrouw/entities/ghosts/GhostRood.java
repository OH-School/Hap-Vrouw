package HapVrouw.entities.ghosts;

import com.github.hanyaeger.api.Coordinate2D;

public class GhostRood extends Ghosts{


    public GhostRood(Coordinate2D initialLocation) {
        super("sprites/ghosts/picture.png",initialLocation);

        setAutoCycle(100,2);
    }
}
