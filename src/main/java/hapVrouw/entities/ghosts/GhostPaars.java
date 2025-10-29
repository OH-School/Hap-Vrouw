package hapVrouw.entities.ghosts;

import com.github.hanyaeger.api.Coordinate2D;
import hapVrouw.entities.hapVrouw.HapVrouw;
import hapVrouw.entities.text.HealthText;
import hapVrouw.entities.text.ScoreText;

public class GhostPaars extends Ghosts {

    public GhostPaars(Coordinate2D initialLocation) {
        super(initialLocation);
        this.row = 1;
    }

    @Override
    public void action(HapVrouw hapVrouw, ScoreText scoreText, HealthText healthText) {
        hapVrouw.setControlsReversed();

    }



}
