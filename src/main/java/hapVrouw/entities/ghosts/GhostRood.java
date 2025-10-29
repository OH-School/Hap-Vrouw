package hapVrouw.entities.ghosts;

import com.github.hanyaeger.api.Coordinate2D;
import hapVrouw.entities.hapVrouw.HapVrouw;
import hapVrouw.entities.text.ScoreText;

public class GhostRood extends Ghosts {
    public GhostRood(Coordinate2D initialLocation) {
        super(initialLocation);
        this.row = 2;
    }

    @Override
    public void action(HapVrouw hapVrouw, ScoreText scoreText) {
        hapVrouw.setPlayerSpeed((hapVrouw.getStandardSpeed()));
        hapVrouw.setAnchorLocation(new Coordinate2D(hapVrouw.initialLocation.getX(), hapVrouw.initialLocation.getY()));
        scoreText.setScoreText(scoreText.getScore() - 100);
    }
}
