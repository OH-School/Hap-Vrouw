package HapVrouw.entities.dots.dots;

import HapVrouw.entities.dots.Dots;
import HapVrouw.entities.text.ScoreText;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;

public class BigDot extends Dots {
    public BigDot(Coordinate2D initialPosition, Size size) {
        super("sprites/dots/smallDot.png", initialPosition, size);
    }

    @Override
    public void addPoints(ScoreText scoreText) {
        scoreText.setScoreText(scoreText.getScore() + 50);
        nDots--;
        this.remove();
    }
}
