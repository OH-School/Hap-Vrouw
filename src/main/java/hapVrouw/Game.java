package hapVrouw;

import hapVrouw.scenes.GameLevelScene;
import hapVrouw.scenes.GameOverScene;
import hapVrouw.scenes.TitleScene;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;



public class Game extends YaegerGame {
    public static void main( String[] args ) {
        launch(args);
    }

    private final int window = 3;

    @Override
    public void setupGame() {
        setGameTitle("hapVrouw");
        setSize(new Size(304 * window, 240 * window));
    }

    @Override
    public void setupScenes() {
        addScene(0, new TitleScene(this));
        addScene(1, new GameLevelScene(this));
        addScene(2, new GameOverScene(this));
    }
}
