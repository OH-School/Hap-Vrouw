package hapVrouw.entities.dots.dots;

import hapVrouw.entities.dots.Dots;
import hapVrouw.entities.hapVrouw.HapVrouw;
import hapVrouw.entities.text.ScoreText;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;

public class SmallDot extends Dots {
    public SmallDot(Coordinate2D initialPosition, Size size) {
        super("sprites/dots/smallDot.png", initialPosition, size);
    }

    @Override
    public void dotAction(ScoreText scoreText, HapVrouw hapVrouw) {
        scoreText.setScoreText(ScoreText.getScore() + 10);
        nDots--;
        this.remove();
    }
}
