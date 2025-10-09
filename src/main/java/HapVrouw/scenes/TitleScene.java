package HapVrouw.scenes;

import HapVrouw.Game;
import HapVrouw.entities.buttons.Button;
import HapVrouw.entities.buttons.quitbutton.QuitButton;
import HapVrouw.entities.buttons.startbutton.StartButton;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.StaticScene;

public class TitleScene extends StaticScene {

    private Game game;

    public TitleScene(Game game) {
        this.game = game;
    }
    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/background1.jpg");
    }

    @Override
    public void setupEntities() {
        Button startButton = new StartButton(new Coordinate2D(getWidth() / 2, getHeight() / 2), "Start", game);
        addEntity(startButton);
        Button quitButton = new QuitButton(new Coordinate2D(getWidth() / 2, getHeight() / 2 + 100), "Quit", game);
        addEntity(quitButton);

    }
}
