package HapVrouw.entities.text;

import com.github.hanyaeger.api.Coordinate2D;

public class ScoreText extends Text {


    public ScoreText(Coordinate2D initialLocation) {
        super(initialLocation);
    }

    public void setScoreText(int score){
        setText("Score: " + score);

    }



}
