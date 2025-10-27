package hapVrouw.entities.ghosts;

import com.github.hanyaeger.api.Coordinate2D;

public class GhostOranje extends Ghosts{

    public GhostOranje( Coordinate2D initialLocation) {
        super("sprites/ghosts/picture.png", initialLocation);

        setAutoCycle(100,0);
    }
}
