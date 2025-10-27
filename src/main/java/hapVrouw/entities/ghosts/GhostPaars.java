package hapVrouw.entities.ghosts;

import com.github.hanyaeger.api.Coordinate2D;

public class GhostPaars extends Ghosts{


    public GhostPaars( Coordinate2D initialLocation) {
        super("sprites/ghosts/picture.png", initialLocation);
        setAutoCycle(100,1);


    }
}
