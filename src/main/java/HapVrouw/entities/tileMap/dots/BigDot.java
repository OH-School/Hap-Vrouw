package HapVrouw.entities.tileMap.dots;

import HapVrouw.entities.text.ScoreText;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;

public class BigDot extends Dots {
    public BigDot(Coordinate2D initialLocation, Size size, String resource) {
        super(initialLocation, size, resource);
    }

    @Override
    public void addPoints(ScoreText scoreText) {
        scoreText.setScoreText(scoreText.getScore() + 50);
    }
}
