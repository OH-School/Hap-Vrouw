package HapVrouw.entities.text;

import com.github.hanyaeger.api.Coordinate2D;

public class ScoreText extends Text {

    private int score; // <-- veld toegevoegd

    public ScoreText(Coordinate2D initialLocation) {
        super(initialLocation);
        setScoreText(0); // begin met score 0
    }

    public void setScoreText(int score) {
        this.score = score;           // waarde opslaan
        setText("Score: " + score);   // tekst updaten
    }

    public int getScore() {
        return this.score;            // actuele score teruggeven
    }
}
