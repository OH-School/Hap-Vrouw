package hapVrouw.entities.dots.dots;

import hapVrouw.entities.dots.Dots;
import hapVrouw.entities.hapVrouw.HapVrouw;
import hapVrouw.entities.text.ScoreText;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;

public class BigDot extends Dots {
    public BigDot(Coordinate2D initialPosition, Size size) {
        super("sprites/dots/bigDot.png", initialPosition, size);
    }

    @Override
    public void dotAction(ScoreText scoreText, HapVrouw hapVrouw) {
        scoreText.setScoreText(ScoreText.getScore() + 50);
        nDots--;
        hapVrouw.becomeSuper();
        this.remove();
    }
}
