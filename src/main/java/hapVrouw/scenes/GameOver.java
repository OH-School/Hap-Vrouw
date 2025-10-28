package hapVrouw.scenes;

import hapVrouw.Game;
import hapVrouw.entities.buttons.Button;
import hapVrouw.entities.buttons.quitbutton.QuitButton;
import hapVrouw.entities.buttons.startbutton.StartButton;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.StaticScene;
import hapVrouw.entities.text.ScoreText;

public class GameOver extends StaticScene {

    private Game game;
    private int finalScore;

    public GameOver(Game game) {
        this.game = game;
        this.finalScore = finalScore;
    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/background1.jpg");
    }

    @Override
    public void setupEntities() {
        ScoreText score = new ScoreText(new Coordinate2D(404,5));
        score.setScoreText(finalScore);
        addEntity(score);
        Button startButton = new StartButton(new Coordinate2D(getWidth() / 2, getHeight() / 2), "Start", game);
        addEntity(startButton);
        Button quitButton = new QuitButton(new Coordinate2D(getWidth() / 2, getHeight() / 2 + 100), "Quit", game);
        addEntity(quitButton);
    }
}
