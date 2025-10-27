package HapVrouw.entities.tileMap.dots;

import HapVrouw.entities.hapVrouw.HapVrouw;
import HapVrouw.entities.text.ScoreText;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;

import java.util.List;

public class SmallDot extends Dots {
    public SmallDot(Coordinate2D initialLocation, Size size, String resource) {
        super(initialLocation, size, resource);
    }

    @Override
    public void addPoints(ScoreText scoreText) {
        scoreText.setScoreText(scoreText.getScore() + 10);
    }
}
