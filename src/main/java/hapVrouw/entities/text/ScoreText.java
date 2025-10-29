package hapVrouw.entities.text;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;

public class ScoreText extends Text {

    private static int score;

    public ScoreText(Coordinate2D initialLocation) {
        super(initialLocation);
        setScoreText(getScore());
    }

    public void setScoreText(int score) {
        if (score < 0) {
            score = 0;
        }
        ScoreText.score = score;
        setText("Score: " + score);
    }

    public static int getScore() {
        return ScoreText.score;
    }
}
